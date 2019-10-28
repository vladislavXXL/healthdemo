package org.healthdemo.service;

import org.healthdemo.entity.Horse;

import java.util.List;

public interface HorseService {

    /**
     * Method required to adding horse.
     *
     * @param horse horse to add
     * @return created horse
     */
    Horse addHorse(Horse horse);

    /**
     * Method required to update horse.
     *
     * @param horse horse to update
     * @return update horse
     */
    Horse updateHorse(Horse horse);

    /**
     * Method required to get horse by id.
     *
     * @param id of horse to get
     * @return get horse by id
     */
    Horse getHorse(long id);

    /**
     * Method required to getting all horses.
     *
     * @return horse by id
     */
    List<Horse> getAllHorses();

    /**
     * Method required to delete horse by id.
     *
     * @param id of horse to delete
     * @return deleted horse by id
     */
    Horse deleteHorse(long id);
}
