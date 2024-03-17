package com.webshop.shoppingcart.domain.model;

import com.webshop.shoppingcart.domain.repository.ShoppingCartRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ShoppingCartItem {

    @Id
    private String id;

    private String inventoryItemId;
    private int amount;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    public static ShoppingCartItem create(String inventoryItemId, int amount) {
        var item = new ShoppingCartItem();
        item.id = ShoppingCartRepository.nextItemIdentity();
        item.amount = amount;
        item.inventoryItemId = inventoryItemId;
        item.createdOn = LocalDateTime.now();
        item.lastModifiedOn = LocalDateTime.now();

        return item;
    }

}
