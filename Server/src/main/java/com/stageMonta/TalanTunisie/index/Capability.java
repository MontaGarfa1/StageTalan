package com.stageMonta.TalanTunisie.index;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "capability", type = "_doc")
public class Capability {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JsonProperty("notifId")
    private String notifId;
    @JsonProperty("meterRID")

    private String meterRID;
    @JsonProperty("notifType")

    private String notifType;
    @JsonProperty("Date")

    private String Date;
    @JsonProperty("capabilitesStatus")

    private String capabilitesStatus;
    @JsonProperty("availabilityDeadline")

    private String availabilityDeadline;
    @JsonProperty("availabilityDate")

    private String availabilityDate;
    @JsonProperty("status")

    private String status;
    @JsonProperty("failureCode")

    private String failureCode;

    public Capability() {
    }

    public String getNotifId() {
        return notifId;
    }

    public void setNotifId(String notifId) {
        this.notifId = notifId;
    }

    public String getMeterRID() {
        return meterRID;
    }

    public void setMeterRID(String meterRID) {
        this.meterRID = meterRID;
    }

    public String getNotifType() {
        return notifType;
    }

    public void setNotifType(String notifType) {
        this.notifType = notifType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCapabilitesStatus() {
        return capabilitesStatus;
    }

    public void setCapabilitesStatus(String capabilitesStatus) {
        this.capabilitesStatus = capabilitesStatus;
    }

    public String getAvailabilityDeadline() {
        return availabilityDeadline;
    }

    public void setAvailabilityDeadline(String availabilityDeadline) {
        this.availabilityDeadline = availabilityDeadline;
    }

    public String getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
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
