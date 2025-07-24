package com.hack.hack25.controller;

import com.hack.hack25.dto.TransactionRequestDTO;
import com.hack.hack25.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/addTransaction")
    public ResponseEntity<String> addTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO)
    {
        transactionService.addTransaction(transactionRequestDTO);
        return ResponseEntity.ok("Added transaction successfully.");
    }
}
