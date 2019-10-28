package org.healthdemo.dao.impl;

import org.healthdemo.dao.HorseDao;
import org.healthdemo.entity.Horse;

public class HorseDaoImpl extends BasicDaoImpl<Horse> implements HorseDao {
    public HorseDaoImpl(Class<Horse> entityClass) {
        super(entityClass);
    }
}
