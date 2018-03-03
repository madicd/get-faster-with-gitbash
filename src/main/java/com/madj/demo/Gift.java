package com.madj.demo;

import java.util.ArrayList;
import java.util.List;

public class Gift {
    private String description;
    private List<Property> properties;

    public Gift(String description, List<Property> properties) {
        this.description = description;
        this.properties = properties;
    }

    public Gift(String description) {
        this.description = description;
        properties = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
