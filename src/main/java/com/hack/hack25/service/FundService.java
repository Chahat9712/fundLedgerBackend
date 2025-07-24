package com.hack.hack25.service;

import com.hack.hack25.model.Fund;
import com.hack.hack25.model.Participant;
import com.hack.hack25.repository.FundRepository;
import com.hack.hack25.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FundService {

    @Autowired
    private FundRepository fundRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public void addUserToFund(String fundName, String userId) {

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

    public String registerUser(String name, double fundValue) {
        Participant p = new Participant();
        p.setUserName(name);
        p.setBalance(fundValue);
        participantRepository.save(p);

        return p.getUserId();
    }

    public Fund getFundByName(String fundName) {
        return fundRepository.findByFundName(fundName);
    }
}
