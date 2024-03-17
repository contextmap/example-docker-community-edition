package com.webshop.shoppingcart.service;

import com.webshop.shoppingcart.model.CheckoutRequest;
import com.webshop.shoppingcart.model.event.CheckoutRequested;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckoutProcessor {

    private final RabbitTemplate rabbitTemplate;
    private final Exchange orderRequestedExchange;
    private final ObjectMapper objectMapper;

    public void process(CheckoutRequest checkoutRequest) {
        log.info("Sending order-requested event");
        try {
            var event = new CheckoutRequested(checkoutRequest.getUserId());
            var messagePayload = objectMapper.writeValueAsString(event);
            rabbitTemplate.convertAndSend(orderRequestedExchange.getName(), "", messagePayload);
        } catch (Exception e) {
            log.error("Error while sending", e);
        }
    }

}
