package org.healthdemo.model.impl;

import org.healthdemo.model.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("croc")
public class Crocodile implements Animal {
    @Override
    public String getInfo() {
        return "Gena";
    }
}
