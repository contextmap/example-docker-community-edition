package com.webshop.shoppingcart.model.common;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(Class<?> type, Object id) {
        super("Could not find entity of type '" + type.getSimpleName() + "' for id '" + id + "'");
    }

}
