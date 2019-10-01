package org.healthdemo.model;

import org.springframework.stereotype.Component;

@Component
public class Rabbit {
    private String name;

    public Rabbit() {
    }

    public Rabbit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
