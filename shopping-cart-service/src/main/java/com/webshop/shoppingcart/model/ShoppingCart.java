package com.webshop.shoppingcart.model;

import com.webshop.shoppingcart.model.id.ShoppingCartId;
import com.webshop.shoppingcart.model.id.UserId;
import com.webshop.shoppingcart.repository.ShoppingCartRepository;
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

    @EmbeddedId
    private ShoppingCartId id;

    @Embedded
    private UserId userId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    private List<ShoppingCartItem> items;

    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    protected ShoppingCart() {
        // for hibernate
    }

    public static ShoppingCart create(UserId userId) {
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

