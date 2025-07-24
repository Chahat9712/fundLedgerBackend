package com.hack.hack25.model;

import lombok.Data;

@Data
public class User {

    private String userId;
    private String userName;
    private Long loanedAmount;
    private Long amountDeposited;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLoanedAmount() {
        return loanedAmount;
    }

    public void setLoanedAmount(Long loanedAmount) {
        this.loanedAmount = loanedAmount;
    }

    public Long getAmountDeposited() {
        return amountDeposited;
    }

    public void setAmountDeposited(Long amountDeposited) {
        this.amountDeposited = amountDeposited;
    }
}
