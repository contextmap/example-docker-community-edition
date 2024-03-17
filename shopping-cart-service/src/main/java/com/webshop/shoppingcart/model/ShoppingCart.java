package com.webshop.shoppingcart.model;

import com.webshop.shoppingcart.repository.ShoppingCartRepository;
import io.contextmap.annotations.ContextGlossary;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@ContextGlossary("""
An ecommerce shopping cart is software that lets users select, store, and manage items before buying them.
It reflects the concept of shopping in a store.
You can add items to the cart that you want to buy, change the quantity, and get a total cost before finishing the transaction.
""")
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

