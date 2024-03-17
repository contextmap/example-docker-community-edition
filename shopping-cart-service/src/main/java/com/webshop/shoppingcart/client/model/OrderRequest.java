package com.webshop.shoppingcart.client.model;

import java.util.List;
import java.util.UUID;

public class OrderRequest {

    public String name;
    public OrderAddress address;
    public List<OrderItem> items;

    public static class OrderAddress {
        public String street;
        public String city;
        public String postalCode;
    }

    public static class OrderItem {
        public UUID productId;
        public int quantity;
    }

}
