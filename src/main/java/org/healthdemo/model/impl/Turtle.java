package org.healthdemo.model.impl;

import org.healthdemo.model.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Turtle implements Animal {
    @Override
    public String getInfo() {
        return "Donatello";
    }
}
