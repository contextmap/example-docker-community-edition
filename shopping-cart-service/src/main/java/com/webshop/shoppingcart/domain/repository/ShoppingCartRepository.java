package com.webshop.shoppingcart.domain.repository;

import com.webshop.shoppingcart.domain.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {

    static String nextIdentity() {
        return UUID.randomUUID().toString();
    }

    static String nextItemIdentity() {
        return UUID.randomUUID().toString();
    }

    boolean existsByUserId(String userId);

}
