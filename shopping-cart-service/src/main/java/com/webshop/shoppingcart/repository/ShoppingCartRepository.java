package com.webshop.shoppingcart.repository;

import com.webshop.shoppingcart.model.ShoppingCart;
import com.webshop.shoppingcart.model.id.ShoppingCartId;
import com.webshop.shoppingcart.model.id.ShoppingCartItemId;
import com.webshop.shoppingcart.model.id.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {

    static ShoppingCartId nextIdentity() {
        return new ShoppingCartId(UUID.randomUUID().toString());
    }

    static ShoppingCartItemId nextItemIdentity() {
        return new ShoppingCartItemId(UUID.randomUUID().toString());
    }

    boolean existsByUserId(UserId userId);

}
