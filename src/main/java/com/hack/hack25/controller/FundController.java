package com.hack.hack25.controller;

import com.hack.hack25.model.Analytics;
import com.hack.hack25.model.Fund;
import com.hack.hack25.model.Transaction;
import com.hack.hack25.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    @PostMapping("/addUserToFund")
    public void addUserToExistingFund(String userId, String fundName)
    {
        fundService.addUserToFund(fundName, userId);
    }

    @GetMapping("/getAllFunds")
    public void getAllFunds(){
        fundService.getAllFunds();
    }

    @PostMapping("/user")
    public String registerUser(String name, double fundValue){
        return fundService.registerUser(name, fundValue);
    }

    @GetMapping("/getFundByName/{fundName}")
    public Fund getFundByName(String fundName)
    {
        return fundService.getFundByName(fundName);
    }

    @GetMapping("/getUserFunds/{userId}")
    public List<Fund> getAllFundsBasedOnUserId(@PathVariable String userId){
        return fundService.getAllFundsByUserId(userId);
    }

    /*List fund details --- participants, hight contributors, fund value, loan amount*/

    @GetMapping("/getAnalytics/{fundName}")
    public Analytics getData(@PathVariable String fundName){
        return fundService.getAnalysis(fundName);
    }

    @PostMapping("/addFund")
    public String addNewFund(String fundName){
        return fundService.addNewFund(fundName);
    }

    @GetMapping("/getFundsTransactions/{userId}")
    public Pair<List<Fund>, List<Transaction>> getFundsAndParticipantsForUser(@PathVariable String userId){
        return fundService.getFundsTransactionsForUser(userId);
    }
}
