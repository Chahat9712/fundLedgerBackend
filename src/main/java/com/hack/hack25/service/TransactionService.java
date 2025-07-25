package com.hack.hack25.service;

import com.hack.hack25.dto.TransactionRequestDTO;
import com.hack.hack25.model.Fund;
import com.hack.hack25.model.Participant;
import com.hack.hack25.model.Transaction;
import com.hack.hack25.model.User;
import com.hack.hack25.repository.FundRepository;
import com.hack.hack25.repository.ParticipantRepository;
import com.hack.hack25.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ParticipantRepository participantRepository;
    private final FundRepository fundRepository;

    public TransactionService(TransactionRepository transactionRepository, ParticipantRepository participantRepository, FundRepository fundRepository)
    {
        this.transactionRepository = transactionRepository;
        this.participantRepository = participantRepository;
        this.fundRepository = fundRepository;
    }

    public void addTransaction(TransactionRequestDTO transactionRequestDTO)
    {
        Participant participant = participantRepository.findByUserName(transactionRequestDTO.getUserName());
        Fund fund = fundRepository.findByFundName(transactionRequestDTO.getFundName());

        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(transactionRequestDTO.getTransactionAmount());
        transaction.setFund(fund);
        transaction.setParticipant(participant);
        transaction.setTransactionDate(new Date());
        transactionRepository.save(transaction);
    }
}
