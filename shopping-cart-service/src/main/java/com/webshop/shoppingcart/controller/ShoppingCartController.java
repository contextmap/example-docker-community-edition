package com.webshop.shoppingcart.controller;

import com.webshop.shoppingcart.controller.model.CreationRequest;
import com.webshop.shoppingcart.controller.model.ShoppingCartResponse;
import com.webshop.shoppingcart.model.ShoppingCartId;
import com.webshop.shoppingcart.model.UserId;
import com.webshop.shoppingcart.service.ShoppingCartService;
import io.contextmap.annotations.rest.ContextRestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webshop.shoppingcart.configuration.WebSecurityConfig.SHOPPING_CART_READ;
import static com.webshop.shoppingcart.configuration.WebSecurityConfig.SHOPPING_CART_WRITE;


@ContextRestApi(
        name = "ShoppingCartController",
        description = "Manage your shopping cart using these endpoints.")
@Slf4j
@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService service;

    @Secured(SHOPPING_CART_READ)
    @GetMapping
    public List<ShoppingCartResponse> getShoppingCarts() {
        log.info("Getting shopping carts");
        return service.getShoppingCarts().stream()
                .map(ShoppingCartResponse::toResponse)
                .toList();
    }

    @Secured(SHOPPING_CART_READ)
    @GetMapping("/{id}")
    public ShoppingCartResponse getShoppingCart(@PathVariable String id) {
        var shoppingCart = service.getShoppingCart(ShoppingCartId.fromString(id));
        return ShoppingCartResponse.toResponse(shoppingCart);
    }

    @Secured(SHOPPING_CART_WRITE)
    @PutMapping("/{id}/item")
    public ResponseEntity<ShoppingCartResponse> putInShoppingCart(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @Secured(SHOPPING_CART_WRITE)
    @DeleteMapping("/{id}/item")
    public ResponseEntity<ShoppingCartResponse> deleteFromShoppingCart(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @Secured(SHOPPING_CART_WRITE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShoppingCart(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @Secured(SHOPPING_CART_WRITE)
    @PostMapping("/{id}/checkout")
    public void checkout(@PathVariable String id) {
        log.info("Checkout shopping cart {}", id);
        service.checkout(ShoppingCartId.fromString(id));
    }

    @Secured(SHOPPING_CART_WRITE)
    @PostMapping
    public ShoppingCartId createShoppingCart(@RequestBody CreationRequest request) {
        log.info("Creating shopping cart for user {}", request.userId());
        return service.createShoppingCart(UserId.fromString(request.userId()));
    }

}
