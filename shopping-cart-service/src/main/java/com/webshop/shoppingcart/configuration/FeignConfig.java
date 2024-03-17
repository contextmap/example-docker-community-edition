package com.webshop.shoppingcart.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(@Value("${credentials.rest.username}") String username,
                                                                   @Value("${credentials.rest.password}") String password) {
        return new BasicAuthRequestInterceptor(username, password);
    }

}
