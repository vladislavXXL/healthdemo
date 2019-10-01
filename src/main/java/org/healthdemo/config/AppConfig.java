package org.healthdemo.config;

import org.healthdemo.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dog dog() {
        return new Dog("Sharik", "sweet");
    }
}
