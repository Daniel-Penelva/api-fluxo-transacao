package com.api.fluxotransacao.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer; // usuario que paga a transação

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private User payee; // usuario que recebe a transação

    private LocalDateTime transactionTime;
}
