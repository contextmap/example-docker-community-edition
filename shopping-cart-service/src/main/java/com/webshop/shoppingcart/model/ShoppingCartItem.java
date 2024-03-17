package com.webshop.shoppingcart.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ShoppingCartItem {

    @EmbeddedId
    private ShoppingCartItemId id;

    private int amount;

}
