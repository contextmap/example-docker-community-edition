package com.webshop.shoppingcart.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
            var messagePayload = objectMapper.writeValueAsString(checkoutRequest);
            rabbitTemplate.convertAndSend(orderRequestedExchange.getName(), "", messagePayload);
        } catch (Exception e) {
            log.error("Error while sending", e);
        }
    }

    @Value
    @Builder
    public static class CheckoutRequest {
        String userId;
        List<CheckoutItem> items;
    }

    @Value
    @Builder
    public static class CheckoutItem {
        String inventoryItemId;
        int amount;
    }

}
