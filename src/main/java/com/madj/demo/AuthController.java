package com.madj.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(path = "/login", method = POST)
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authHeader) {
        String[] splitted = authHeader.split(" ");
        String credentialsBase64 = splitted[1];

        if (!"ZHJ1bms6c2FudGE=".equals(credentialsBase64)) {
            return new ResponseEntity<>("Bad credentials!", HttpStatus.BAD_REQUEST);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Demo-Authorization", UUID.randomUUID().toString());
        ResponseEntity<String> response = new ResponseEntity<>("Santa, you're in!", responseHeaders, HttpStatus.ACCEPTED);

        return response;
    }
}
