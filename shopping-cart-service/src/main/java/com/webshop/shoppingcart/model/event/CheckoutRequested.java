package com.webshop.shoppingcart.model.event;

import com.webshop.shoppingcart.model.UserId;

public record CheckoutRequested(UserId userId) { }
