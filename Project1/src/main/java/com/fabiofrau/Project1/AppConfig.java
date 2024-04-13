package com.fabiofrau.Project1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean("bean1")
    @Profile("dev")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First bean");
    }

    @Bean
    @Profile("test")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Bean");
    }

    @Bean
    @Profile("prod")
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Bean");
    }

}
