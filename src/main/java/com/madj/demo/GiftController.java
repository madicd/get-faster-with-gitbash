package com.madj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.madj.demo.DemoConstants.X_DEMO_AUTHORIZATION_HEADER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GiftController {

    private static final List<Gift> GIFTS = new ArrayList<>();


    static {
        GIFTS.add(new Gift("Cotton candies"));

        {
            List<Property> properties = new ArrayList<>();
            properties.add(new Property("weight", "2kg"));
            properties.add(new Property("price", "10 euro"));

            GIFTS.add(new Gift("Chocolate bars", properties));
        }

        {
            List<Property> properties = new ArrayList<>();
            properties.add(new Property("weight", "2kg"));
            properties.add(new Property("price", "25 euro"));

            GIFTS.add(new Gift("Toys", properties));
        }
    }

    private final TokenService tokenService;

    @Autowired
    public GiftController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(path = "/gifts", method = GET)
    public ResponseEntity<List<Gift>> getAll(@RequestHeader(X_DEMO_AUTHORIZATION_HEADER) String token) {
        if (!tokenService.isValid(token)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(GIFTS, HttpStatus.OK);
    }
}
