package org.healthdemo.config;

import org.healthdemo.dao.EmployeeDao;
import org.healthdemo.dao.HorseDao;
import org.healthdemo.dao.impl.EmployeeDaoImpl;
import org.healthdemo.dao.impl.HorseDaoImpl;
import org.healthdemo.entity.Employee;
import org.healthdemo.entity.Horse;
import org.healthdemo.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Dog dog() {
        return new Dog("Sharik", "sweet");
    }

    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }
}
