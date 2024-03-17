package com.webshop.shoppingcart.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String virtualHost = "/";
    public static final String exchangeName = "shoppingcart-checkout";

    @Bean
    public CachingConnectionFactory connectionFactory(@Value("${credentials.messaging.username}") String username,
                                                      @Value("${credentials.messaging.password}") String password) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses("localhost:5672");
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost(virtualHost);
        cachingConnectionFactory.setRequestedHeartBeat(20);

        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(CachingConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Exchange orderRequestedExchange(RabbitAdmin rabbitAdmin) {
        FanoutExchange exchange = new FanoutExchange(exchangeName);
        exchange.setAdminsThatShouldDeclare(rabbitAdmin);
        return exchange;
    }

}
