package com.hack.hack25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participant extends User {

    private double balance;
    private double loanedAmount;

    @ManyToMany(mappedBy = "participants")
    private List<Fund> participantFunds = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoanedAmount() {
        return loanedAmount;
    }

    public void setLoanedAmount(double loanedAmount) {
        this.loanedAmount = loanedAmount;
    }

    public List<Fund> getParticipantFunds() {
        return participantFunds;
    }

    public void setParticipantFunds(List<Fund> participantFunds) {
        this.participantFunds = participantFunds;
    }
}
