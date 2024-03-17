package com.webshop.shoppingcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping(produces = TEXT_PLAIN_VALUE)
    public String ping() {
        return "pong";
    }

}
