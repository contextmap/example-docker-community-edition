package com.webshop.shoppingcart.domain.model;

import com.webshop.shoppingcart.domain.repository.ShoppingCartRepository;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
public class ShoppingCart {

    @Id
    private String id;

    private String userId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private List<ShoppingCartItem> items;

    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    protected ShoppingCart() {
        // for hibernate
    }

    public static ShoppingCart create(String userId) {
        var shoppingCart = new ShoppingCart();
        shoppingCart.id = ShoppingCartRepository.nextIdentity();
        shoppingCart.userId = userId;
        shoppingCart.items = new ArrayList<>();
        shoppingCart.createdOn = LocalDateTime.now();
        shoppingCart.lastModifiedOn = LocalDateTime.now();

        return shoppingCart;
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
        lastModifiedOn = LocalDateTime.now();
    }

}

