package com.webshop.shoppingcart.service;

import com.webshop.shoppingcart.model.ShoppingCart;
import com.webshop.shoppingcart.model.ShoppingCartId;
import com.webshop.shoppingcart.model.UserId;
import com.webshop.shoppingcart.model.common.EntityNotFound;
import com.webshop.shoppingcart.model.common.EntityNotUnique;
import com.webshop.shoppingcart.repository.ShoppingCartRepository;
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

  public ShoppingCart getShoppingCart(ShoppingCartId id) {
      return shoppingCartRepository.findById(id)
              .orElseThrow(() -> new EntityNotFound(ShoppingCart.class, id));
  }

  public void checkout(ShoppingCartId id) {
      var shoppingCart = getShoppingCart(id);
      var checkoutRequest = shoppingCart.checkout();
      checkoutProcessor.process(checkoutRequest);
  }

}
