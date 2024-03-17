package com.webshop.shoppingcart.service.exceptions;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(Class<?> type, Object id) {
        super("Could not find entity of type '" + type.getSimpleName() + "' for id '" + id + "'");
    }

}
