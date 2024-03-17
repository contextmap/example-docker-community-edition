package com.webshop.shoppingcart.model;

import com.webshop.shoppingcart.repository.ShoppingCartRepository;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
public class ShoppingCart {

    @EmbeddedId
    private ShoppingCartId id;

    @Embedded
    private UserId userId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    private List<ShoppingCartItem> items;

    protected ShoppingCart() {
        // for hibernate
    }

    public static ShoppingCart create(UserId userId) {
        var shoppingCart = new ShoppingCart();
        shoppingCart.id = ShoppingCartRepository.nextIdentity();
        shoppingCart.userId = userId;

        return shoppingCart;
    }

    public CheckoutRequest checkout() {
        return new CheckoutRequest(userId);
    }

}

