package com.webshop.shoppingcart.model;

import com.webshop.shoppingcart.model.id.InventoryItemId;
import com.webshop.shoppingcart.model.id.ShoppingCartItemId;
import com.webshop.shoppingcart.repository.ShoppingCartRepository;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ShoppingCartItem {

    @EmbeddedId
    private ShoppingCartItemId id;

    @Embedded
    private InventoryItemId inventoryItemId;

    private int amount;

    public static ShoppingCartItem create(InventoryItemId inventoryItemId, int amount) {
        var item = new ShoppingCartItem();
        item.id = ShoppingCartRepository.nextItemIdentity();
        item.amount = amount;
        item.inventoryItemId = inventoryItemId;

        return item;
    }

}
