package com.stageMonta.TalanTunisie.index;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "meter", type = "_doc")
public class Meter {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String meterRID;
    private String type;
    private String comType;
    private String lifeCycleStatus;
    private String connectivityStatus;
    private String amrRouter;
    private String cellId;
    private String discoveryDate;
    private String installDate;
    private String reconcillationDate;
    private String activationDate;
    private String removalDate;
    private String initCapabilityDeadline;
    private String initCapabilityDate;
    private String hwVersion;
    private String fwVersion;
    private String breakerStatus;
    private String isExludedFromKpi;
    private String collectGroup;
    private String signalStrength;
    private String currentCapaStatus;

    public Meter() {
    }

    public Meter(String type, String comType, String lifeCycleStatus, String connectivityStatus, String amrRouter, String cellId, String discoveryDate, String installDate, String reconcillationDate, String activationDate, String removalDate, String initCapabilityDeadline, String initCapabilityDate, String hwVersion, String fwVersion, String breakerStatus, String isExludedFromKpi, String collectGroup, String signalStrength, String currentCapaStatus) {
        this.type = type;
        this.comType = comType;
        this.lifeCycleStatus = lifeCycleStatus;
        this.connectivityStatus = connectivityStatus;
        this.amrRouter = amrRouter;
        this.cellId = cellId;
        this.discoveryDate = discoveryDate;
        this.installDate = installDate;
        this.reconcillationDate = reconcillationDate;
        this.activationDate = activationDate;
        this.removalDate = removalDate;
        this.initCapabilityDeadline = initCapabilityDeadline;
        this.initCapabilityDate = initCapabilityDate;
        this.hwVersion = hwVersion;
        this.fwVersion = fwVersion;
        this.breakerStatus = breakerStatus;
        this.isExludedFromKpi = isExludedFromKpi;
        this.collectGroup = collectGroup;
        this.signalStrength = signalStrength;
        this.currentCapaStatus = currentCapaStatus;
    }

    public String getMeterRID() {
        return meterRID;
    }

    public void setMeterRID(String meterRID) {
        this.meterRID = meterRID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public void setLifeCycleStatus(String lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    public String getConnectivityStatus() {
        return connectivityStatus;
    }

    public void setConnectivityStatus(String connectivityStatus) {
        this.connectivityStatus = connectivityStatus;
    }

    public String getAmrRouter() {
        return amrRouter;
    }

    public void setAmrRouter(String amrRouter) {
        this.amrRouter = amrRouter;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getReconcillationDate() {
        return reconcillationDate;
    }

    public void setReconcillationDate(String reconcillationDate) {
        this.reconcillationDate = reconcillationDate;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(String removalDate) {
        this.removalDate = removalDate;
    }

    public String getInitCapabilityDeadline() {
        return initCapabilityDeadline;
    }

    public void setInitCapabilityDeadline(String initCapabilityDeadline) {
        this.initCapabilityDeadline = initCapabilityDeadline;
    }

    public String getInitCapabilityDate() {
        return initCapabilityDate;
    }

    public void setInitCapabilityDate(String initCapabilityDate) {
        this.initCapabilityDate = initCapabilityDate;
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    public String getBreakerStatus() {
        return breakerStatus;
    }

    public void setBreakerStatus(String breakerStatus) {
        this.breakerStatus = breakerStatus;
    }

    public String getIsExludedFromKpi() {
        return isExludedFromKpi;
    }

    public void setIsExludedFromKpi(String isExludedFromKpi) {
        this.isExludedFromKpi = isExludedFromKpi;
    }

    public String getCollectGroup() {
        return collectGroup;
    }

    public void setCollectGroup(String collectGroup) {
        this.collectGroup = collectGroup;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getCurrentCapaStatus() {
        return currentCapaStatus;
    }

    public void setCurrentCapaStatus(String currentCapaStatus) {
        this.currentCapaStatus = currentCapaStatus;
    }
}
