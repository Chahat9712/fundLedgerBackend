package com.hack.hack25.service;

import com.hack.hack25.model.Analytics;
import com.hack.hack25.model.Fund;
import com.hack.hack25.model.Participant;
import com.hack.hack25.model.Transaction;
import com.hack.hack25.repository.FundRepository;
import com.hack.hack25.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FundService {

    @Autowired
    private FundRepository fundRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public void addUserToFund(String fundName, Long userId) {

        Fund f = fundRepository.findByFundName(fundName);
        List<Participant> ps = f.getParticipants();

        try{
            ps.add(participantRepository.findByUserId(userId));
        }
        catch (Exception e){
            System.out.println("User not found. Please register first.");
            throw new ApplicationContextException("User not found. Please register first.");
        }

        fundRepository.save(f);
    }

    public void getAllFunds() {
        fundRepository.findAll();
    }

    public Long registerUser(String name, double fundValue) {
        Participant p = new Participant();
        p.setUserName(name);
        p.setBalance(fundValue);
        participantRepository.save(p);

        return p.getUserId();
    }

    public Fund getFundByName(String fundName) {
        return fundRepository.findByFundName(fundName);
    }

    public List<Fund> getAllFundsByUserId(String userId) {

        Participant participant = participantRepository.findByUserId(userId);

        return participant.getParticipantFunds();
    }

    public Analytics getAnalysis(String fundId) {

        Fund f = fundRepository.findByFundName(fundId);

        List<Participant> participants = f.getParticipants();

        Analytics a = new Analytics();
        Participant x = participants.stream()
                .max(Comparator.comparingDouble(Participant::getBalance)).orElse(null);

        a.setHighestContributor(x.getUserName());
        a.setFundBal(f.getFundValue());
        a.setLoanedAmt(f.getLoanValue());

        return a;

    }

    public String addNewFund(String fundName) {

        Fund f = new Fund();
        f.setFundName(fundName);
        f.setFundValue(500.00);

        fundRepository.save(f);

        return "Fund created successfully";
    }

    public Pair<List<Fund>, List<Transaction>> getFundsTransactionsForUser(String userId) {

        Participant participant = participantRepository.findByUserId(userId);

        // Initialize empty lists for funds and transactions
        List<Fund> funds = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();

        // If participant exists, get funds and their transactions
        if (participant != null) {
            funds = participant.getParticipantFunds();
            if (funds != null) {
                transactions = funds.stream()
                        .filter(fund -> fund.getTransactions() != null) // Avoid null transactions
                        .flatMap(fund -> fund.getTransactions().stream())
                        .collect(Collectors.toList());
            }
        }

        // Return Pair of funds and transactions
        return Pair.of(funds != null ? funds : new ArrayList<>(),
                transactions != null ? transactions : new ArrayList<>());
    }
}
