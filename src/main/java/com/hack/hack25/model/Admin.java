package com.hack.hack25.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Admin {

    private String adminId;
    private String adminName;
    private List<Fund> funds = new ArrayList<>();

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }
}
