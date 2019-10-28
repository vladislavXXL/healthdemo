package org.healthdemo.dao;

import java.util.List;

public interface BasicDao<T> {

    /**
     * Method required to adding entity.
     *
     * @param entity entity to add
     * @return created entity
     */
    T addEntity(T entity);

    /**
     * Method required to update entity.
     *
     * @param entity entity to update
     * @return update entity
     */
    T updateEntity(T entity);

    /**
     * Method required to get entity by id.
     *
     * @param id of entity to get
     * @return get entity by id
     */
    T getEntity(long id);

    /**
     * Method required to get all entities.
     *
     * @return entity by id
     */
    List<T> getAllEntities();

    /**
     * Method required to delete entity by id.
     *
     * @param entity - entity to delete
     * @return deleted entity by id
     */
    T deleteEntity(T entity);
}
