package com.stageMonta.TalanTunisie.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "kpiConfig", type = "_doc")
public class KpiConfig {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JsonProperty("id")
    private String id;
    @JsonProperty("kpiName")
    private String kpiName;
    @JsonProperty("kpiDescription")
    private String kpiDescription;
    @JsonProperty("periodOfCalculation")
    private String periodOfCalculation;
    @JsonProperty("Weight")
    private float Weight;
    @JsonProperty("serviceLevelTarget")
    private float serviceLevelTarget;

    public KpiConfig() {

    }

    public KpiConfig(String kpiName, String kpiDescription, String periodOfCalculation, float weight, float serviceLevelTarget) {
        this.kpiName = kpiName;
        this.kpiDescription = kpiDescription;
        this.periodOfCalculation = periodOfCalculation;
        Weight = weight;
        this.serviceLevelTarget = serviceLevelTarget;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getKpiDescription() {
        return kpiDescription;
    }

    public void setKpiDescription(String kpiDescription) {
        this.kpiDescription = kpiDescription;
    }

    public String getPeriodOfCalculation() {
        return periodOfCalculation;
    }

    public void setPeriodOfCalculation(String periodOfCalculation) {
        this.periodOfCalculation = periodOfCalculation;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public float getServiceLevelTarget() {
        return serviceLevelTarget;
    }

    public void setServiceLevelTarget(float serviceLevelTarget) {
        this.serviceLevelTarget = serviceLevelTarget;
    }
}
