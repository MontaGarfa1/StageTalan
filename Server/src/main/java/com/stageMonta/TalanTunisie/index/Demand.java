package com.stageMonta.TalanTunisie.index;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "demand", type = "_doc")
public class Demand {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String demandRid;
    private String meterMRID;
    private String serviceType;
    private String requestDate;
    private Long slaPriority;
    private String responseDeadline;
    private String responseDate;
    private String status;
    private String failureCode;

    public Demand(){
    }

    public Demand(String meterMRID, String serviceType, String requestDate, Long slaPriority, String responseDeadline, String responseDate, String status, String failureCode) {
        this.meterMRID = meterMRID;
        this.serviceType = serviceType;
        this.requestDate = requestDate;
        this.slaPriority = slaPriority;
        this.responseDeadline = responseDeadline;
        this.responseDate = responseDate;
        this.status = status;
        this.failureCode = failureCode;
    }

    public String getDemandRid() {
        return demandRid;
    }

    public void setDemandRid(String demandRid) {
        this.demandRid = demandRid;
    }

    public String getMeterMRID() {
        return meterMRID;
    }

    public void setMeterMRID(String meterMRID) {
        this.meterMRID = meterMRID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Long getSlaPriority() {
        return slaPriority;
    }

    public void setSlaPriority(Long slaPriority) {
        this.slaPriority = slaPriority;
    }

    public String getResponseDeadline() {
        return responseDeadline;
    }

    public void setResponseDeadline(String responseDeadline) {
        this.responseDeadline = responseDeadline;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }
}
