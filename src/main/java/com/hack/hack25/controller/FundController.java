package com.hack.hack25.controller;

import com.hack.hack25.model.Fund;
import com.hack.hack25.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    @PostMapping
    public void addUserToExistingFund(Long userId, String fundName)
    {
        fundService.addUserToFund(fundName, userId);
    }

    @GetMapping
    public void getAllFunds(){
        fundService.getAllFunds();
    }

    @PostMapping
    public String registerUser(String name, double fundValue){
        return fundService.registerUser(name, fundValue);
    }

    @GetMapping
    public Fund getFundByName(String fundName)
    {
        return fundService.getFundByName(fundName);
    }
}
