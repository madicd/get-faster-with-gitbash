package com.madj.demo;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private static final List<Ticket> TICKETS = new LinkedList<>();

    static {
        {
            List<Property> props = new LinkedList<>();
            props.add(new Property("owner", "Perica"));
            props.add(new Property("entrance", "West"));
            TICKETS.add(new Ticket(props));
        }
        {
            List<Property> props = new LinkedList<>();
            props.add(new Property("owner", "Marica"));
            props.add(new Property("entrance", "East"));
            TICKETS.add(new Ticket(props));
        }
        {
            List<Property> props = new LinkedList<>();
            props.add(new Property("owner", "Ivica"));
            props.add(new Property("entrance", "North"));
            TICKETS.add(new Ticket(props));
        }
        {
            List<Property> props = new LinkedList<>();
            props.add(new Property("owner", "Jovica"));
            props.add(new Property("entrance", "West"));
            TICKETS.add(new Ticket(props));
        }
    }

    @RequestMapping
    public List<Ticket> getAll(@RequestHeader(DemoConstants.X_DEMO_AUTHORIZATION) String token) {
        return TICKETS;
    }
}


