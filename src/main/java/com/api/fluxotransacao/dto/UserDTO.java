package com.api.fluxotransacao.dto;

import com.api.fluxotransacao.domain.UserType;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserDTO {

    private String name;
    private String document;
    private String email;
    private String password;
    private UserType userType;
    private BigDecimal balance;
}
