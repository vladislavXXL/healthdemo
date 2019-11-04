package org.healthdemo.service;


import org.healthdemo.dto.EmployeeDto;
import org.healthdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * Method required to adding employee.
     *
     * @param employee employee to add
     * @return created employee
     */
    Employee addEmployee(Employee employee);

    /**
     * Method required to update employee.
     *
     * @param employee employee to update
     * @return update employee
     */
    Employee updateEmployee(Employee employee);

    /**
     * Method required to get employee by id.
     *
     * @param id of employee to get
     * @return get employee by id
     */
    EmployeeDto getEmployee(long id);

    /**
     * Method required to getting all employee.
     *
     * @return employee by id
     */
    List<Employee> getAllEmployees();

    /**
     * Method required to delete employee by id.
     *
     * @param id of employee to delete
     * @return deleted employee by id
     */
    Employee deleteEmployee(long id);

}
