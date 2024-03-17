package com.webshop.shoppingcart.client;

import io.contextmap.annotations.client.ContextClient;
import com.webshop.shoppingcart.client.model.BankingDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.UUID;

// Example showing that HttpExchanges are documented, however some nudging is needed to know the name of the target service
@ContextClient(name = "user-service")
@HttpExchange("/users")
public interface UserServiceClient {

    @GetExchange("/{userId}/banking")
    BankingDetails getBankingDetails(@PathVariable UUID userId);

}
