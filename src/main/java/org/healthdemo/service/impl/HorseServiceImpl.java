package org.healthdemo.service.impl;

import org.healthdemo.dao.HorseDao;
import org.healthdemo.entity.Horse;
import org.healthdemo.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("horseService")
public class HorseServiceImpl implements HorseService {
    private HorseDao horseDao;

    @Override
    public Horse addHorse(Horse horse) {
        return horseDao.addEntity(horse);
    }

    @Override
    public Horse updateHorse(Horse horse) {
        return horseDao.updateEntity(horse);
    }

    @Override
    public Horse getHorse(long id) {
        return horseDao.getEntity(id);
    }

    @Override
    public List<Horse> getAllHorses() {
        return horseDao.getAllEntities();
    }

    @Override
    public Horse deleteHorse(long id) {
        return horseDao.deleteEntity(getHorse(id));
    }

    @Autowired
    public void setHorseDao(HorseDao horseDao) {
        this.horseDao = horseDao;
    }
}
