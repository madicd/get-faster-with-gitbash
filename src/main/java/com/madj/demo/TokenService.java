package com.madj.demo;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class TokenService {

    private List<String> validTokens = new LinkedList<>();

    public String getToken() {
        String token = UUID.randomUUID().toString();
        validTokens.add(token);
        return token;
    }

    public boolean isValid(String token) {
        return validTokens.contains(token);
    }
}
