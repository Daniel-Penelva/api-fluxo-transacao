package com.api.fluxotransacao.service;

import com.api.fluxotransacao.domain.User;
import com.api.fluxotransacao.dto.UserDTO;
import com.api.fluxotransacao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO user){
        var newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
