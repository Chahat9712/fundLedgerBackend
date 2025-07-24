package com.hack.hack25.controller;

import com.hack.hack25.dto.TransactionRequestDTO;
import com.hack.hack25.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @GetMapping("/addTransaction")
    public ResponseEntity<String> addTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)
    {
        transactionService.addTransaction(transactionRequestDTO);
        return ResponseEntity.ok("Added transaction successfully.");
    }
}
