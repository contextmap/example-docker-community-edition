package com.webshop.shoppingcart.model.common;

public class EntityNotUnique extends RuntimeException {

    public EntityNotUnique(Class<?> type, Object reference) {
        super("An entity of type '" + type.getSimpleName() + "' for '" + reference + "' already exists");
    }
}
