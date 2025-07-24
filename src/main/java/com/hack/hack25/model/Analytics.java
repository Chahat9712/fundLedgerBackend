package com.hack.hack25.model;

public class Analytics {

    private String highestContributor;
    private double fundBal;
    private double loanedAmt;

    public String getHighestContributor() {
        return highestContributor;
    }

    public void setHighestContributor(String highestContributor) {
        this.highestContributor = highestContributor;
    }

    public double getFundBal() {
        return fundBal;
    }

    public void setFundBal(double fundBal) {
        this.fundBal = fundBal;
    }

    public double getLoanedAmt() {
        return loanedAmt;
    }

    public void setLoanedAmt(double loanedAmt) {
        this.loanedAmt = loanedAmt;
    }
}
