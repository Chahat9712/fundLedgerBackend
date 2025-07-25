package com.hack.hack25.service;

import com.hack.hack25.dto.FundResponseDTO;
import com.hack.hack25.model.*;
import com.hack.hack25.repository.AdminRepository;
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

    @Autowired
    private AdminRepository adminRepository;

    public String addUserToFund(String fundName, Long userId) {

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

        return "User added to the input fund";
    }

    public List<String> getAllFunds() {
        List<Fund> funds = fundRepository.findAll();
        List<String> ls = new ArrayList<>();
        for(Fund f : funds)
        {
            ls.add(f.getFundName());
        }

        return ls;
    }

    public Participant registerUser(String name, double fundValue) {
        Participant p = new Participant();
        p.setUserName(name);
        p.setBalance(fundValue);
        Participant saved = participantRepository.save(p);

        return saved;
    }

    public FundResponseDTO getFundByName(String fundName) {
        Fund fund = fundRepository.findByFundName(fundName);
        List<Participant> participants = fund.getParticipants();
        List<String> ls = new ArrayList<>();
        FundResponseDTO fundResponseDTO = new FundResponseDTO();
        fundResponseDTO.setFundName(fund.getFundName());
        for (Participant participant : fund.getParticipants())
        {
            ls.add(participant.getUserName());
        }
        fundResponseDTO.setParticipants(ls);
        Participant x = participants.stream()
                .max(Comparator.comparingDouble(Participant::getBalance)).orElse(null);

        fundResponseDTO.setHighestContributor(x.getUserName());
        fundResponseDTO.setFundValue(fund.getFundValue());
        fundResponseDTO.setLoanValue(fund.getLoanValue());

        return fundResponseDTO;
    }

    public List<Fund> getAllFundsByUserId(Long userId) {

        Participant participant = participantRepository.findByUserId(userId);

        return participant.getParticipantFunds();
    }

    public String addNewFund(String fundName) {

        Fund f = new Fund();
        f.setFundName(fundName);
        f.setFundValue(500.00);

        Admin a = adminRepository.findByUserId(1L);
        f.setAdmin(a);

        fundRepository.save(f);

        return "Fund created successfully";
    }

    public Pair<List<Fund>, List<Transaction>> getFundsTransactionsForUser(Long userId) {

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
