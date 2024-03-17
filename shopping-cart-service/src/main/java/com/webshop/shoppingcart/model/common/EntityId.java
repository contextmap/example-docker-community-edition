package com.webshop.shoppingcart.model.common;

public abstract class EntityId {

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }

}
