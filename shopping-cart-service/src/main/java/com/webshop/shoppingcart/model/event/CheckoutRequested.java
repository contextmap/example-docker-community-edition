package com.webshop.shoppingcart.model.event;

import com.webshop.shoppingcart.model.UserId;
import io.contextmap.annotations.ContextEvent;

import static com.webshop.shoppingcart.configuration.RabbitMQConfig.exchangeName;

@ContextEvent(publishedBy = exchangeName)
public record CheckoutRequested(UserId userId) { }
