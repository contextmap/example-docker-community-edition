package com.webshop.shoppingcart.controller;

import io.contextmap.annotations.rest.ContextRestApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@ContextRestApi(
        name = "HealthController",
        description = "Endpoints to check the health of this service and its dependencies")
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping(produces = TEXT_PLAIN_VALUE)
    public String ping() {
        return "pong";
    }

}
