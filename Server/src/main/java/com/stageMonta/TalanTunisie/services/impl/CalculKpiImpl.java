package com.stageMonta.TalanTunisie.services.impl;

import com.stageMonta.TalanTunisie.index.*;
import com.stageMonta.TalanTunisie.services.CalculKpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CalculKpiImpl implements CalculKpi {
    Logger logger = LoggerFactory.getLogger(CalculKpiImpl.class);



    @Override
    public float DD_VCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        return this.FC(meterDailyMetrics)/this.GM(meterDailyMetrics);
    }

    @Override
    public float DD_VCB2(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        return this.FCNG(meterDailyMetrics)/this.NGM(meterDailyMetrics);
    }

    @Override
    public float DD_TCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics,Capability capability)throws ParseException {
        return this.TBC(meterDailyMetrics,capability)/this.NGM(meterDailyMetrics);
    }

    @Override
    public float DD_CCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException {
        return this.AC(meterDailyMetrics)/this.GM(meterDailyMetrics);
    }

    @Override
    public float DD_TCM1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException {
        return this.TPD(meterDailyMetrics)/this.PD(meterDailyMetrics);
    }

    @Override
    public float DD_VCM1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException {
        return this.VM(meterDailyMetrics)/this.PD(meterDailyMetrics);
    }

    @Override
    public float SC_TMC1(ArrayList<MeterDailyMetrics> meterDailyMetrics,ArrayList<Demand> demandArrayList)throws ParseException {
        return this.TMC(meterDailyMetrics,demandArrayList)/this.MC(meterDailyMetrics,demandArrayList);
    }


    private float GM(ArrayList<MeterDailyMetrics> meterDailyMetrics){
        float i=0;
        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            if(!meterDailyMetric.isExcludedFromKpi())
            i++;
        }
        return i;
    }
    private float FC(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            if(meterDailyMetric.getNbOfDeamndsFailure()==0){
                Date lastdateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(meterDailyMetric.getCollectTypeDeadline().size()-1));

                /** last collect deadline in measurement periode*/
                for (int j=0;j<meterDailyMetric.getCollectTypeDeadline().size();j++){
                    Date dateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(j));
                    Date dateType = formatter.parse(meterDailyMetric.getCollectTypeTimesTamp().get(j));
                    if(dateType.before(dateDeadline) && meterDailyMetric.getCollectTypeStatus().get(j).toUpperCase().equalsIgnoreCase("OK")){
                        i++;}
                    }

            }

        }
        return i;
    }
    private float FCNG(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            Date reconciliationdate =formatter.parse(meterDailyMetric.getReconcilaTionDate());
            /** add reconciliationdate in measurment period*/
            if(meterDailyMetric.getNbOfDeamndsFailure()==0){
                Date lastdateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(meterDailyMetric.getCollectTypeDeadline().size()-1));
               /**  addlast collect deadline in measurement periode*/
                for (int j=0;j<meterDailyMetric.getCollectTypeDeadline().size();j++){
                    Date dateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(j));
                    Date dateType = formatter.parse(meterDailyMetric.getCollectTypeTimesTamp().get(j));
                    if(dateType.before(dateDeadline) && meterDailyMetric.getCollectTypeStatus().get(j).toUpperCase().equalsIgnoreCase("OK") ){
                        i++;}
                }

            }

        }
        logger.info(String.valueOf(i));
        return i;
    }
    private float NGM(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            Date reconciliationdate =formatter.parse(meterDailyMetric.getReconcilaTionDate());
            /** add reconciliationdate in measurment period*/
            if(!meterDailyMetric.isExcludedFromKpi())
                i++;
        }
        return i;
    }
    private float AC(ArrayList<MeterDailyMetrics> meterDailyMetrics){
        float i=0;
        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            if (meterDailyMetric.getNbOfCapaNegativeAdjustements()!=0)
                i++;
        }
        return i;
    }
    private float PD(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {

            if (meterDailyMetric.getCollectTypeDeadline().size()>0){
                Date lastCollectDeadline = formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(meterDailyMetric.getCollectTypeDeadline().size()-1));
                /** add last Collect Deadline in measurement period */
                i++;
            }
        }
        return i;
    }
    private float TPD(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException {
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
                Date lastdateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(meterDailyMetric.getCollectTypeDeadline().size()-1));

                /** last collect deadline in measurement periode*/
                for (int j=0;j<meterDailyMetric.getCollectTypeDeadline().size();j++){
                    Date dateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(j));
                    Date dateType = formatter.parse(meterDailyMetric.getCollectTypeTimesTamp().get(j));
                    if(dateType.before(dateDeadline) && meterDailyMetric.getCollectTypeStatus().get(j).toUpperCase().equalsIgnoreCase("OK")){
                        i++;}
                }

        }
        return i;
    }
    private float VM(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException{
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            Date lastdateDeadline= formatter.parse(meterDailyMetric.getCollectTypeDeadline().get(meterDailyMetric.getCollectTypeDeadline().size()-1));

            /** add last collect deadline in measurement periode*/
            for (int j=0;j<meterDailyMetric.getCollectTypeDeadline().size();j++){
                Date xxxxtimestamp= formatter.parse(meterDailyMetric.getCollectTypeTimesTamp().get(j));
                /** add timesstamp in measurement period*/
                if (meterDailyMetric.getCollectTypeStatus().get(j).toUpperCase().equalsIgnoreCase("OK")){
                    i++;}
            }

        }
        return i;
    }
    private float TBC(ArrayList<MeterDailyMetrics> meterDailyMetrics,Capability capability) throws ParseException{
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (MeterDailyMetrics meterDailyMetric : meterDailyMetrics) {
            Date firstCapabilyDAY= formatter.parse(capability.getDate());
            Date deadlinefirstCapabilyDAY= formatter.parse(capability.getAvailabilityDeadline());
            if(firstCapabilyDAY.before(deadlinefirstCapabilyDAY)){
                Date reconciliationdate = formatter.parse(meterDailyMetric.getReconcilaTionDate());
                /** Reconciliation date in the measurement period */
            }

        }
        return i;
    }
    private float MC(ArrayList<MeterDailyMetrics> meterDailyMetrics,ArrayList<Demand> demandArrayList) throws ParseException{
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (Demand demand : demandArrayList) {
            Date responseDeadline = formatter.parse(demand.getResponseDeadline());
            /** add response deadline in measurement period*/
                i++;
        }
        return i;
    }
    private float TMC(ArrayList<MeterDailyMetrics> meterDailyMetrics,ArrayList<Demand> demandArrayList)  throws ParseException{
        float i=0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (Demand demand : demandArrayList) {
            //Date executionDate = formatter.parse(demand.get
            /**
                add Execution day < Execution deadline
                add Execution deadline in measurement period
             */
            if(demand.getStatus().toUpperCase().equalsIgnoreCase("SUCCESS")){
                i++;
            }
            
        }
        return i;
    }

}
