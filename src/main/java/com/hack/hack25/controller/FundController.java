package com.hack.hack25.controller;

import com.hack.hack25.model.Analytics;
import com.hack.hack25.model.Fund;
import com.hack.hack25.model.Transaction;
import com.hack.hack25.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Long registerUser(String name, double fundValue){
        return fundService.registerUser(name, fundValue);
    }

    @GetMapping
    public Fund getFundByName(String fundName)
    {
        return fundService.getFundByName(fundName);
    }

    @GetMapping
    public List<Fund> getAllFundsBasedOnUserId(String userId){
        return fundService.getAllFundsByUserId(userId);
    }

    /*List fund details --- participants, hight contributors, fund value, loan amount*/

    @GetMapping
    public Analytics getData(String fundName){
        return fundService.getAnalysis(fundName);
    }

    @PostMapping
    public String addNewFund(String fundName){
        return fundService.addNewFund(fundName);
    }

    @GetMapping
    public Pair<List<Fund>, List<Transaction>> getFundsAndParticipantsForUser(String userId){
        return fundService.getFundsTransactionsForUser(userId);
    }
}
