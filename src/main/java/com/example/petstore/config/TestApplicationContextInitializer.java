package com.example.petstore.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class TestApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.setProperty("wiot_apikey", "dummy_apikey");
        System.setProperty("wiot_token", "dummy_token");
        System.setProperty("wiot_org", "dummy_org");
    }

}
