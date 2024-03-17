package com.webshop.shoppingcart.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "shopping-cart-service",
                version = "v1",
                contact = @Contact(
                        name = "Team Awesome",
                        email = "awesome@webshop.com"
                )
        ),
        security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {
}

