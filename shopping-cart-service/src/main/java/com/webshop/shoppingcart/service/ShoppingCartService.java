package com.webshop.shoppingcart.service;

import com.webshop.shoppingcart.model.ShoppingCart;
import com.webshop.shoppingcart.model.ShoppingCartItem;
import com.webshop.shoppingcart.model.common.EntityNotFound;
import com.webshop.shoppingcart.model.common.EntityNotUnique;
import com.webshop.shoppingcart.model.id.InventoryItemId;
import com.webshop.shoppingcart.model.id.ShoppingCartId;
import com.webshop.shoppingcart.model.id.UserId;
import com.webshop.shoppingcart.repository.ShoppingCartRepository;
import com.webshop.shoppingcart.service.CheckoutProcessor.CheckoutItem;
import com.webshop.shoppingcart.service.CheckoutProcessor.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingCartService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final CheckoutProcessor checkoutProcessor;

  public List<ShoppingCart> getShoppingCarts() {
      return shoppingCartRepository.findAll();
  }

  @Transactional
  public ShoppingCartId createShoppingCart(UserId id) {
      if (shoppingCartRepository.existsByUserId(id)) {
          throw new EntityNotUnique(ShoppingCart.class, "user " + id);
      }

      var newShoppingCart = ShoppingCart.create(id);
      shoppingCartRepository.save(newShoppingCart);
      return newShoppingCart.getId();
  }

  @Transactional
  public void addItem(ShoppingCartId id, InventoryItemId inventoryItemId, int amount) {
      var shoppingCart = getShoppingCart(id);
      var item = ShoppingCartItem.create(inventoryItemId, amount);
      shoppingCart.addItem(item);
      shoppingCartRepository.save(shoppingCart);
  }

  public ShoppingCart getShoppingCart(ShoppingCartId id) {
      return shoppingCartRepository.findById(id)
              .orElseThrow(() -> new EntityNotFound(ShoppingCart.class, id));
  }

  public void checkout(ShoppingCartId id) {
      var shoppingCart = getShoppingCart(id);
      var checkoutRequest = convertToRequest(shoppingCart);
      checkoutProcessor.process(checkoutRequest);
  }

  private CheckoutRequest convertToRequest(ShoppingCart shoppingCart) {
      return CheckoutRequest.builder()
              .userId(shoppingCart.getUserId().getValue())
              .items(shoppingCart.getItems().stream()
                      .map(this::convertToRequestItem)
                      .toList())
              .build();
  }

  private CheckoutItem convertToRequestItem(ShoppingCartItem item) {
      return CheckoutItem.builder()
              .inventoryItemId(item.getInventoryItemId().getValue())
              .amount(item.getAmount())
              .build();
  }

}
