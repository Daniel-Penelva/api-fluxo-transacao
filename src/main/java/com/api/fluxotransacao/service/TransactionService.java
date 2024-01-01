package com.api.fluxotransacao.service;

import com.api.fluxotransacao.domain.Transaction;
import com.api.fluxotransacao.dto.TransactionDTO;
import com.api.fluxotransacao.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserService userService;
    private final RestTemplate restTemplate;
    private final TransactionRepository repository;
    private final NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception {
        var payer = this.userService.findUserById(transactionDTO.getPayerId());
        var payee = this.userService.findUserById(transactionDTO.getPayeeId());

        userService.validateUser(payer, transactionDTO.getAmount());

        boolean isAuthorize = authorizeTransaction(); // verifica se a transação está autorizada para acontecer

        if (!isAuthorize) {
            throw new Exception("Transação não autorizado!");
        }

        // Criando a transação
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transactionDTO.getAmount());
        newTransaction.setPayer(payer);
        newTransaction.setPayee(payee);
        newTransaction.setTransactionTime(LocalDateTime.now());

        // subtrai o valor da balança pelo valor da transação
        payer.setBalance(payer.getBalance().subtract(transactionDTO.getAmount()));
        payee.setBalance(payee.getBalance().add(transactionDTO.getAmount()));

        this.repository.save(newTransaction);
        this.userService.saveUser(payer);
        this.userService.saveUser(payee);

        notificationService.sendNotification(payer, "Transação realizada com sucesso!");
        notificationService.sendNotification(payee, "Transação recebida com sucesso!");

        return newTransaction;
    }

    public boolean authorizeTransaction() {
        var response = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String message = (String) response.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }
}
