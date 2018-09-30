package com.stageMonta.TalanTunisie.index;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;

@Document(indexName = "meterDailyMetrics", type = "_doc")
public class MeterDailyMetrics {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String mRID;
    private String creationTimpstamp;
    private String reconcilaTionDate;
    private String lastUpdateTimestamp;
    private boolean isExcludedFromKpi;
    private Long nbOfDeamndsFailure;
    private ArrayList<String> collectTypeDeadline;
    private ArrayList<String> collectTypeTimesTamp;
    private ArrayList<String> collectTypeStatus;
    private Long nbOfCapaNegativeAdjustements;

    public MeterDailyMetrics() {
    }

    public MeterDailyMetrics(String creationTimpstamp, String reconcilaTionDate, String lastUpdateTimestamp, boolean isExcludedFromKpi, Long nbOfDeamndsFailure, ArrayList<String> collectTypeDeadline, ArrayList<String> collectTypeTimesTamp, ArrayList<String> collectTypeStatus, Long nbOfCapaNegativeAdjustements) {
        this.creationTimpstamp = creationTimpstamp;
        this.reconcilaTionDate = reconcilaTionDate;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.isExcludedFromKpi = isExcludedFromKpi;
        this.nbOfDeamndsFailure = nbOfDeamndsFailure;
        this.collectTypeDeadline = collectTypeDeadline;
        this.collectTypeTimesTamp = collectTypeTimesTamp;
        this.collectTypeStatus = collectTypeStatus;
        this.nbOfCapaNegativeAdjustements = nbOfCapaNegativeAdjustements;
    }

    public String getmRID() {
        return mRID;
    }

    public void setmRID(String mRID) {
        this.mRID = mRID;
    }

    public String getCreationTimpstamp() {
        return creationTimpstamp;
    }

    public void setCreationTimpstamp(String creationTimpstamp) {
        this.creationTimpstamp = creationTimpstamp;
    }

    public String getReconcilaTionDate() {
        return reconcilaTionDate;
    }

    public void setReconcilaTionDate(String reconcilaTionDate) {
        this.reconcilaTionDate = reconcilaTionDate;
    }

    public String getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public boolean isExcludedFromKpi() {
        return isExcludedFromKpi;
    }

    public void setExcludedFromKpi(boolean excludedFromKpi) {
        isExcludedFromKpi = excludedFromKpi;
    }

    public Long getNbOfDeamndsFailure() {
        return nbOfDeamndsFailure;
    }

    public void setNbOfDeamndsFailure(Long nbOfDeamndsFailure) {
        this.nbOfDeamndsFailure = nbOfDeamndsFailure;
    }

    public ArrayList<String> getCollectTypeDeadline() {
        return collectTypeDeadline;
    }

    public void setCollectTypeDeadline(ArrayList<String> collectTypeDeadline) {
        this.collectTypeDeadline = collectTypeDeadline;
    }

    public ArrayList<String> getCollectTypeTimesTamp() {
        return collectTypeTimesTamp;
    }

    public void setCollectTypeTimesTamp(ArrayList<String> collectTypeTimesTamp) {
        this.collectTypeTimesTamp = collectTypeTimesTamp;
    }

    public ArrayList<String> getCollectTypeStatus() {
        return collectTypeStatus;
    }

    public void setCollectTypeStatus(ArrayList<String> collectTypeStatus) {
        this.collectTypeStatus = collectTypeStatus;
    }

    public Long getNbOfCapaNegativeAdjustements() {
        return nbOfCapaNegativeAdjustements;
    }

    public void setNbOfCapaNegativeAdjustements(Long nbOfCapaNegativeAdjustements) {
        this.nbOfCapaNegativeAdjustements = nbOfCapaNegativeAdjustements;
    }
}
