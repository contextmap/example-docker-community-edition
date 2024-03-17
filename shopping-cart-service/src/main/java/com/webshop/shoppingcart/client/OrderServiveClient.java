package com.webshop.shoppingcart.client;

import com.webshop.shoppingcart.client.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Example showing that FeignClients are documented
@FeignClient(name = "order-service")
public interface OrderServiveClient {

    @PostMapping ("/orders/{userId}")
    List<Order> getPriorOrders(@PathVariable String userId);

}
