package com.api.fluxotransacao.domain;

import com.api.fluxotransacao.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private UserType userType;
    private BigDecimal balance;

    public User(UserDTO dto) {
        this.name = dto.getName();
        this.document = dto.getDocument();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.userType = dto.getUserType();
        this.balance = dto.getBalance();
    }

}
