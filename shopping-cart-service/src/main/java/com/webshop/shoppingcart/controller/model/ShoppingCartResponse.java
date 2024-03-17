package com.webshop.shoppingcart.controller.model;

import com.webshop.shoppingcart.model.ShoppingCart;
import com.webshop.shoppingcart.model.id.ShoppingCartId;

import java.util.List;


public record ShoppingCartResponse(String id, List<ShoppingCartItemResponse> items) {

    public static ShoppingCartResponse toResponse(ShoppingCart source) {
        return new ShoppingCartResponse(
                source.getId().getValue(),
                source.getItems().stream()
                        .map(item -> new ShoppingCartItemResponse(item.getInventoryItemId().getValue(), item.getAmount()))
                        .toList());
    }

    public record ShoppingCartItemResponse(String inventoryItemId, int amount) {}

}
