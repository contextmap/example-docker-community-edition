package com.webshop.shoppingcart.client;

import com.webshop.shoppingcart.client.model.BankingDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.UUID;

@HttpExchange("/users")
public interface UserServiceClient {

    @GetExchange("/{userId}/banking")
    BankingDetails getBankingDetails(@PathVariable UUID userId);

}
