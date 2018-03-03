package com.madj.demo;

import org.springframework.stereotype.Component;

import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64String;

@Component
public class UserService {

    private static final String VALID_CREDENTIALS = encodeBase64String("drunk:santa".getBytes());

    boolean validCredentials(String credentialsBase64) {
        return VALID_CREDENTIALS.equals(credentialsBase64);
    }
}
