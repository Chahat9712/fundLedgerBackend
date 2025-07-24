package com.hack.hack25.model;

import lombok.Data;

import java.util.List;

@Data
public class Participants extends User{

    private String participantId;
    private double participantBalance;

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public double getParticipantBalance() {
        return participantBalance;
    }

    public void setParticipantBalance(double participantBalance) {
        this.participantBalance = participantBalance;
    }

    public void setParticipantName(String name){
        super.setUserName(name);
    }

    public String getParticipantName(){
        return super.getUserName();
    }

}
