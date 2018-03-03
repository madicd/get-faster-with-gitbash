package com.madj.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(path = "/gifts", method = GET)
    public List<Gift> getAll() {
        return GIFTS;
    }

}
