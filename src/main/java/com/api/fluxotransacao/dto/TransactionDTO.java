package com.api.fluxotransacao.dto;

import com.api.fluxotransacao.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private BigDecimal amount;
    private Long payerId;
    private Long payeeId;
}
