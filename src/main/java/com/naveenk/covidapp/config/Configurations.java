package com.naveenk.covidapp.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class Configurations {

    @Bean
    public RestTemplate getInstance(){

        return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(10)).setReadTimeout(Duration.ofSeconds(10)).build();
    }
}
