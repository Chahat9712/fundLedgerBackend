package com.hack.hack25.service;

import com.hack.hack25.dto.FundResponseDTO;
import com.hack.hack25.exception.CommonException;
import com.hack.hack25.model.*;
import com.hack.hack25.repository.AdminRepository;
import com.hack.hack25.repository.FundRepository;
import com.hack.hack25.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    public String addUserToFund(String fundName, String userId) {

        Fund f = fundRepository.findByFundName(fundName);
        List<Participant> ps = f.getParticipants();

        try{

            ps.add(participantRepository.findByUserName(userId));

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
        if(fund == null) {
            throw new CommonException("No fund found with name: "+fundName);
        }
        List<Participant> participants = fund.getParticipants();
        FundResponseDTO fundResponseDTO = new FundResponseDTO();
        fundResponseDTO.setFundName(fund.getFundName());
        fundResponseDTO.setFundValue(fund.getFundValue());
        fundResponseDTO.setLoanValue(fund.getLoanValue());
        if(!CollectionUtils.isEmpty(participants)) {
            List<String> ls = new ArrayList<>();
            fund.getParticipants().stream().forEach(participant -> ls.add(participant.getUserName()));
            fundResponseDTO.setParticipants(ls);
            Participant x = participants.stream()
                    .max(Comparator.comparingDouble(Participant::getBalance)).orElse(null);

            fundResponseDTO.setHighestContributor(x.getUserName());
        }

        return fundResponseDTO;
    }

    public List<Fund> getAllFundsByUserId(Long userId) {

        Participant participant = participantRepository.findByUserId(userId);

        return participant.getParticipantFunds();
    }

    public String addNewFund(String fundName) {

        Fund f = Fund.builder().fundName(fundName).fundValue(500.00).build();

        Admin a = adminRepository.findByUserId(1001L);
        f.setAdmin(a);

        fundRepository.save(f);

        return "Fund created successfully";
    }

    public Pair<List<Fund>, List<Transaction>> getFundsTransactionsForUser(String userId) {

        Participant participant = participantRepository.findByUserName(userId);

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
