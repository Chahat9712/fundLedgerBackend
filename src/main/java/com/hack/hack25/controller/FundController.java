package com.hack.hack25.controller;

import com.hack.hack25.dto.FundResponseDTO;
import com.hack.hack25.model.*;
import com.hack.hack25.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funds")
public class FundController {

    @Autowired
    private FundService fundService;

    @PostMapping("/addUserToFund")
    public String addUserToExistingFund(@RequestBody AddUserModel model)
    {
        return fundService.addUserToFund(model.getFname(), model.getId());
    }

    @GetMapping("/getAllFunds")
    public List<String> getAllFunds(){
        return fundService.getAllFunds();
    }

    @PostMapping("/user")
    public Participant registerUser(@RequestBody UserModel userModel){
        return fundService.registerUser(userModel.getName(), 5000.00);
    }

    @GetMapping("/getFundByName/{fundName}")
    public FundResponseDTO getFundByName(@PathVariable String fundName)
    {
        return fundService.getFundByName(fundName);
    }

    @GetMapping("/getUserFunds/{userId}")
    public List<Fund> getAllFundsBasedOnUserId(@PathVariable Long userId){
        return fundService.getAllFundsByUserId(userId);
    }

    /*List fund details --- participants, hight contributors, fund value, loan amount*/

    @PostMapping("/addFund")
    public String addNewFund(@RequestBody AddUserModel addUserModel){
        return fundService.addNewFund(addUserModel.getFname());
    }

    @GetMapping("/getFundsTransactions/{userId}")
    public Pair<List<Fund>, List<Transaction>> getFundsAndParticipantsForUser(@PathVariable Long userId){
        return fundService.getFundsTransactionsForUser(userId);
    }
}
