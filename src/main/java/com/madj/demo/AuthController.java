package com.madj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.madj.demo.DemoConstants.X_DEMO_AUTHORIZATION_HEADER;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AuthController {

    private final TokenService tokenService;

    @Autowired
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(path = "/login", method = POST)
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authHeader) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_DEMO_AUTHORIZATION_HEADER, tokenService.getToken());

        return new ResponseEntity<>("Welcome!", responseHeaders, HttpStatus.ACCEPTED);
    }

}
