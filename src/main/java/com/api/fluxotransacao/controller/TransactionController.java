package com.api.fluxotransacao.controller;

import com.api.fluxotransacao.domain.Transaction;
import com.api.fluxotransacao.dto.TransactionDTO;
import com.api.fluxotransacao.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    // http://localhost:8080/transactions/create
    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        var newTransaction = service.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
