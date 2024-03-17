package com.webshop.shoppingcart.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI/Swagger is not required for ContextMap, ContextMap will scan the REST/message API with or without this dependency.
 * However, very often OpenAPI/Swagger will already be configured on a project, and this example demonstrates that both
 * can be combined without any issues.
 */
@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "shopping-cart-service",
                description = "This service will be the only backend aware of the existence of Shopping Carts.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Team Awesome",
                        email = "awesome@webshop.com"
                )
        ),
        security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {
}

