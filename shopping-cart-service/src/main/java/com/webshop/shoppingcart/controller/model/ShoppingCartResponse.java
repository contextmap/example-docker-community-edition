package com.webshop.shoppingcart.controller.model;

import com.webshop.shoppingcart.model.ShoppingCart;
import com.webshop.shoppingcart.model.ShoppingCartId;


public record ShoppingCartResponse(ShoppingCartId id) {

    public static ShoppingCartResponse toResponse(ShoppingCart source) {
        var dto = new ShoppingCartResponse(source.getId());

        return dto;
    }

}
