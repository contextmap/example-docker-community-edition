package com.webshop.shoppingcart.model;


import com.webshop.shoppingcart.model.common.EntityId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartId extends EntityId implements Serializable {

    @Column(name = "shopping_cart_id")
    private String value;

    public static ShoppingCartId fromString(String value) {
        return new ShoppingCartId(value);
    }

}
