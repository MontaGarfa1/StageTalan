package com.stageMonta.TalanTunisie.index;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Kpi {
    @Id
    private String idKpi;
    private String kpiname;
    private String date;
    private String lastUpdateTimestamp;
    private float value;
    private float deviationFromTarget;
    private int nbOfIncludedMeters;

    public Kpi() {
    }

    public Kpi(String idKpi, String kpiname, String date, String lastUpdateTimestamp, float value, float deviationFromTarget, int nbOfIncludedMeters) {
        this.idKpi = idKpi;
        this.kpiname = kpiname;
        this.date = date;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.value = value;
        this.deviationFromTarget = deviationFromTarget;
        this.nbOfIncludedMeters = nbOfIncludedMeters;
    }

    public String getIdKpi() {
        return idKpi;
    }

    public void setIdKpi(String idKpi) {
        this.idKpi = idKpi;
    }

    public String getKpiname() {
        return kpiname;
    }

    public void setKpiname(String kpiname) {
        this.kpiname = kpiname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getDeviationFromTarget() {
        return deviationFromTarget;
    }

    public void setDeviationFromTarget(float deviationFromTarget) {
        this.deviationFromTarget = deviationFromTarget;
    }

    public int getNbOfIncludedMeters() {
        return nbOfIncludedMeters;
    }

    public void setNbOfIncludedMeters(int nbOfIncludedMeters) {
        this.nbOfIncludedMeters = nbOfIncludedMeters;
    }
}
