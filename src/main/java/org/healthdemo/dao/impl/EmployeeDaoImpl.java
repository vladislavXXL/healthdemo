package org.healthdemo.dao.impl;

import org.healthdemo.dao.EmployeeDao;
import org.healthdemo.entity.Employee;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}
