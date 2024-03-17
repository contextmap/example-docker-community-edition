package com.webshop.shoppingcart.controller.model;

import com.webshop.shoppingcart.domain.model.ShoppingCart;

import java.util.List;


public record ShoppingCartResponse(String id, List<ShoppingCartItemResponse> items) {

    public static ShoppingCartResponse toResponse(ShoppingCart source) {
        return new ShoppingCartResponse(
                source.getId(),
                source.getItems().stream()
                        .map(item -> new ShoppingCartItemResponse(item.getInventoryItemId(), item.getAmount()))
                        .toList());
    }

    public record ShoppingCartItemResponse(String inventoryItemId, int amount) {}

}
