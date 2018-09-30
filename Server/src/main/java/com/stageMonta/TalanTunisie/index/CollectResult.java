package com.stageMonta.TalanTunisie.index;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(indexName = "dailykpi", type = "_doc")
public class CollectResult {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String resultID;
    private String meterRID;
    private String readingType;
    private String readingDate;
    private Long slaPriority;
    private String availabilityDeadline;
    private String avaibilityDate;
    private String status;
    private String failureCode;

    public CollectResult( ) {

    }

    public CollectResult(String meterRID, String readingType, String readingDate, Long slaPriority, String availabilityDeadline, String avaibilityDate, String status, String failureCode) {
        this.meterRID = meterRID;
        this.readingType = readingType;
        this.readingDate = readingDate;
        this.slaPriority = slaPriority;
        this.availabilityDeadline = availabilityDeadline;
        this.avaibilityDate = avaibilityDate;
        this.status = status;
        this.failureCode = failureCode;
    }

    public String getResultID() {
        return resultID;
    }

    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public String getMeterRID() {
        return meterRID;
    }

    public void setMeterRID(String meterRID) {
        this.meterRID = meterRID;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }

    public Long getSlaPriority() {
        return slaPriority;
    }

    public void setSlaPriority(Long slaPriority) {
        this.slaPriority = slaPriority;
    }

    public String getAvailabilityDeadline() {
        return availabilityDeadline;
    }

    public void setAvailabilityDeadline(String availabilityDeadline) {
        this.availabilityDeadline = availabilityDeadline;
    }

    public String getAvaibilityDate() {
        return avaibilityDate;
    }

    public void setAvaibilityDate(String avaibilityDate) {
        this.avaibilityDate = avaibilityDate;
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
