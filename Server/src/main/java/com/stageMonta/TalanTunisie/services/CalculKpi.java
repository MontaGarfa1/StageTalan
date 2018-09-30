package com.stageMonta.TalanTunisie.services;

import com.stageMonta.TalanTunisie.index.*;

import java.text.ParseException;
import java.util.ArrayList;

public interface CalculKpi {

    public float DD_VCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException;
    public float DD_VCB2(ArrayList<MeterDailyMetrics> meterDailyMetrics) throws ParseException;
    public float DD_TCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics,Capability capability) throws ParseException;
    public float DD_CCB1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException;
    public float DD_TCM1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException;
    public float DD_VCM1(ArrayList<MeterDailyMetrics> meterDailyMetrics)throws ParseException;
    public float SC_TMC1(ArrayList<MeterDailyMetrics> meterDailyMetrics,ArrayList<Demand> demandArrayList)throws ParseException;
}
