package com.webshop.shoppingcart;

import io.contextmap.annotations.actor.ContextActor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@ContextActor("Customer")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShoppingCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServiceApplication.class, args);
	}
}
