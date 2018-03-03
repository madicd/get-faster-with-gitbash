package com.madj.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    private final TokenService tokenService;

    @Autowired
    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @RequestMapping(path = "/login", method = POST)
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authHeader) {
        String credentials = credentialsFromBasicAuthHeader(authHeader);

        if (!userService.validCredentials(credentials)) {
            return new ResponseEntity<>("Bad credentials!", HttpStatus.BAD_REQUEST);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(X_DEMO_AUTHORIZATION_HEADER, tokenService.getToken());
        ResponseEntity<String> response = new ResponseEntity<>("Santa, you're in!", responseHeaders, HttpStatus.ACCEPTED);

        return response;
    }

    private String credentialsFromBasicAuthHeader(@RequestHeader("Authorization") String authHeader) {
        String[] splitted = authHeader.split(" ");
        return splitted[1];
    }

}
