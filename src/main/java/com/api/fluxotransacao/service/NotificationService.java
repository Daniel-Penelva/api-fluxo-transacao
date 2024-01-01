package com.api.fluxotransacao.service;

import com.api.fluxotransacao.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(User user, String message) {
        String email = user.getEmail();
        System.out.println(email + message);
    }
}
