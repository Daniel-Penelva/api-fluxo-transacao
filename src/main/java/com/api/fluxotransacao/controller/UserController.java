package com.api.fluxotransacao.controller;

import com.api.fluxotransacao.domain.User;
import com.api.fluxotransacao.dto.UserDTO;
import com.api.fluxotransacao.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // http://localhost:8080/users/create
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = service.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/users/all
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        var users = this.service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
