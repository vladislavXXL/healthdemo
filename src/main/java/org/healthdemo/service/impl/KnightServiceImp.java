package org.healthdemo.service.impl;

import org.healthdemo.service.KnightService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("knightService")
public class KnightServiceImp implements KnightService {

    @Override
    public String getAchievement(String enemy) {
        if (enemy.equalsIgnoreCase("dragon")) {
            throw new IllegalArgumentException("I can't slay a " + enemy);
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am slay the " + enemy;
    }

}
