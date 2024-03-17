package com.webshop.shoppingcart.model;


import com.webshop.shoppingcart.model.common.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartItemId extends EntityId implements Serializable {

    @Column(name = "shopping_cart_item_id")
    private String value;

    public static ShoppingCartItemId fromString(String value) {
        return new ShoppingCartItemId(value);
    }

}
