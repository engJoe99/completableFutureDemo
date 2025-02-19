package com.boghdady.completablefuturedemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * Creates and configures a RestTemplate bean for making HTTP requests
     * RestTemplate is a Spring class used for client-side HTTP access
     * This bean can be autowired in other components that need to make REST calls
     *
     * @return RestTemplate instance that can be used throughout the application
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
