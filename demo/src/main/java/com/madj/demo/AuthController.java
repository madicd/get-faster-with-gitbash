package com.madj.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AuthController {

    @RequestMapping(path = "/login", method = POST)
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authHeader) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(DemoConstants.X_DEMO_AUTHORIZATION, UUID.randomUUID().toString());

        return new ResponseEntity<>("Welcome!", responseHeaders, ACCEPTED);
    }

    @RequestMapping(path = "/logout", method = POST)
    public ResponseEntity<String> logout(@RequestHeader(DemoConstants.X_DEMO_AUTHORIZATION) String token) {
        return new ResponseEntity<>("Goodbye!", ACCEPTED);
    }
}
