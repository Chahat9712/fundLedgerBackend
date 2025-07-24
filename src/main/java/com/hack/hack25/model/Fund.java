package com.hack.hack25.model;

import lombok.Data;

import java.util.List;

@Data
public class Fund {

    private String fundId;
    private String fundName;
    private String fundType;
    private double fundValue;
    private List<Participants> participants;

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public double getFundValue() {
        return fundValue;
    }

    public void setFundValue(double fundValue) {
        this.fundValue = fundValue;
    }

    public List<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participants> participants) {
        this.participants = participants;
    }
}
