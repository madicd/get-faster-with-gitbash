package com.madj.demo;

import java.util.List;
import java.util.UUID;

public class Ticket {
    private String id;
    private String href;
    private List<Property> properties;

    public Ticket(List<Property> properties) {
        this.id = UUID.randomUUID().toString();
        this.href = String.format("http://localhost:8080/ticket/%s", id);
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
