package com.stageMonta.TalanTunisie.services.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.stageMonta.TalanTunisie.index.*;
import com.stageMonta.TalanTunisie.services.CalculKpi;
import com.stageMonta.TalanTunisie.services.DailyKpiService;
import com.stageMonta.TalanTunisie.services.GenerateKpi;
import com.stageMonta.TalanTunisie.services.KpiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GenerateKpiImpl implements GenerateKpi {
    Logger logger = LoggerFactory.getLogger(GenerateKpiImpl.class);
    @Autowired
    DailyKpiService dailyKpiService;
    @Autowired
    CalculKpi calculKpi;

    @Override
    public Kpi saveKpi(ArrayList<String> info) throws IOException, ParseException {
        float value = 0;
        try {
            ObjectMapper mapper = new ObjectMapper();
            /**
             PARSE JSON KPI CONFIG TO OBJECT
             */

            KpiConfig kpiConfig = mapper.readValue(info.get(0), KpiConfig.class);
            /**
              PARSE JSON LIST METER / DEMAND / COLLECT RESULT / CAPABILITY
                TO ARRAYLIST
             */
            ArrayList<Meter> meterArrayList = new ArrayList<Meter>();

            ArrayList<Demand> demandArrayList = new ArrayList<Demand>();
            ArrayList<CollectResult> collectResultArrayList = new ArrayList<CollectResult>();
            ArrayList<Capability> capabilityArrayList = new ArrayList<Capability>();

            meterArrayList = mapper.readValue(info.get(1), new TypeReference<List<Meter>>() {
            });
          demandArrayList= mapper.readValue(info.get(2), new TypeReference<List<Demand>>() { });;
           collectResultArrayList= mapper.readValue(info.get(3), new TypeReference<List<CollectResult>>() { });;
           capabilityArrayList=mapper.readValue(info.get(4), new TypeReference<List<Capability>>() { });;


            /**
             GENERATE METER DAILY METRICS
             */
            ArrayList<MeterDailyMetrics> metricsArrayList = new ArrayList<MeterDailyMetrics>();
            for (Meter meter : meterArrayList) {
                MeterDailyMetrics meterDailyMetrics1 = this.genarateMeterDailyMetrics(meter, this.demandsMeter(meter.getMeterRID(), demandArrayList), this.collectResultMeter(meter.getMeterRID(), collectResultArrayList), this.capabilityMeter(meter.getMeterRID(), capabilityArrayList));
                if (meterDailyMetrics1 != null) {
                    metricsArrayList.add(meterDailyMetrics1);
                }

            }

            logger.info((kpiConfig.getKpiName().toUpperCase()));
            /**
             CALCULER KPI VALUE (FROM KPI NAME)
             CLASSE : CALUCL KPI.
             */
            switch (kpiConfig.getKpiName().toUpperCase()){
                case "DD_VCB1":value = calculKpi.DD_VCB1(metricsArrayList);break;
                case "DD_VCB2":value = calculKpi.DD_VCB2(metricsArrayList);break;
                case "DD_TCB1":value = calculKpi.DD_TCB1(metricsArrayList,capabilityArrayList.get(0));break;
                case "DD_CCB1":value = calculKpi.DD_CCB1(metricsArrayList);break;
                case "DD_TCM1":value = calculKpi.DD_TCM1(metricsArrayList);break;
                case "DD-VCM1":value = calculKpi.DD_VCM1(metricsArrayList);break;
                case "SC_TMC1":value = calculKpi.SC_TMC1(metricsArrayList,demandArrayList);break;
                default: {
                    logger.info("default");
                    return null;
                }

            }
            /**
             Creation Kpi selon type
             ADDED TO DATABASE
             */
            String typeKpi ="dailyKpi";
            switch (typeKpi){
                case "dailyKpi":{
                    DailyKpi dailyKpi = new DailyKpi();
                    dailyKpi.setKpiname(kpiConfig.getKpiName());
                    Date date = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    dailyKpi.setDate(formater.format(date));
                    dailyKpi.setLastUpdateTimestamp(formater.format(date));
                    dailyKpi.setValue(value);
                    dailyKpi.setNbOfIncludedMeters(meterArrayList.size());
                    dailyKpi.setDeviationFromTarget(value-kpiConfig.getServiceLevelTarget());
                    logger.info("kpi name: "+dailyKpi.getKpiname());
                    return dailyKpiService.create(dailyKpi);}
                case "monthlyKpi":;break;
                case "weeklyKpu":;break;
                default:return null;


            }

        }catch (JsonParseException e){
            logger.info("error to convert" + e);
        } /*catch (Exception e) {
            logger.info("error to convert");
        }*/
        return null;
    }

    /**
     METER DAILY METERICS POUR CHAQUE METER
     */
    private MeterDailyMetrics genarateMeterDailyMetrics(Meter meter, ArrayList<Demand> demandArrayList, ArrayList<CollectResult> collectResultArrayList, ArrayList<Capability> capabilityArrayList) {
        MeterDailyMetrics meterDailyMetrics = new MeterDailyMetrics();
        meterDailyMetrics.setmRID(meter.getMeterRID());
        meterDailyMetrics.setCreationTimpstamp(meter.getDiscoveryDate());
        meterDailyMetrics.setReconcilaTionDate(meter.getReconcillationDate());
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        meterDailyMetrics.setLastUpdateTimestamp(formater.format(date));
        if (meter.getIsExludedFromKpi().toUpperCase().equalsIgnoreCase("TRUE"))
        {meterDailyMetrics.setExcludedFromKpi(true);}
        else {meterDailyMetrics.setExcludedFromKpi(false);}
        int nb = 0;
        for (Demand demand : demandArrayList) {
            if (!demand.getStatus().toUpperCase().equalsIgnoreCase("FAIL")) {
                nb++;
            }
        }
     //   meterDailyMetrics.setNbOfDeamndsFailure(Long.valueOf(nb));
        meterDailyMetrics.setNbOfDeamndsFailure((long) 0);
        ArrayList<String> collectTypeDeadline = new ArrayList<String>();
        ArrayList<String> collectTypeTimesTamp = new ArrayList<String>();
        ArrayList<String> collectTypeStatus= new ArrayList<String>();
        for (CollectResult collectResult : collectResultArrayList) {
            collectTypeDeadline.add(collectResult.getAvailabilityDeadline());
            collectTypeTimesTamp.add(collectResult.getAvaibilityDate());
            collectTypeStatus.add(collectResult.getStatus());
        }
        meterDailyMetrics.setCollectTypeDeadline(collectTypeDeadline);
        meterDailyMetrics.setCollectTypeStatus(collectTypeStatus);
        meterDailyMetrics.setCollectTypeTimesTamp(collectTypeTimesTamp);
        meterDailyMetrics.setNbOfCapaNegativeAdjustements((long) demandArrayList.size());
        //calcul
        int nb1=0;
        for (Capability capability : capabilityArrayList) {

        }

        return meterDailyMetrics;
    }

    ;
    /**
        DEMAND LIST POUR CHAQUE METER (ID=
     */
    private ArrayList<Demand> demandsMeter(String id, ArrayList<Demand> demandArrayList) {
        ArrayList<Demand> demandArrayList1 = new ArrayList<Demand>();
        for (Demand demand : demandArrayList) {
            if (demand.getMeterMRID().equalsIgnoreCase(id)) {
                demandArrayList1.add(demand);
            }

        }
        return demandArrayList1;
    }

    ;
    /**
     COLLECT RESULT LIST POUR CHAQUE METER (ID=
     */
    private ArrayList<CollectResult> collectResultMeter(String id, ArrayList<CollectResult> collectResultArrayList) {
        ArrayList<CollectResult> collectResultArrayList1 = new ArrayList<CollectResult>();
        logger.info("mete id  "+id);
        for (CollectResult demand : collectResultArrayList) {
            if (demand.getMeterRID().equalsIgnoreCase(id)) {
                collectResultArrayList1.add(demand);
            }

        }
        return collectResultArrayList1;
    }

    ;
    /**
     CAPABILITY LIST POUR CHAQUE METER (ID=
     */
    private ArrayList<Capability> capabilityMeter(String id, ArrayList<Capability> capabilityArrayList) {
        ArrayList<Capability> capabilityArrayList1 = new ArrayList<Capability>();
        for (Capability capability : capabilityArrayList) {
            if (capability.getMeterRID().equalsIgnoreCase(id)) {
                capabilityArrayList1.add(capability);
            }
        }
        return capabilityArrayList1;
    }

    ;
}
