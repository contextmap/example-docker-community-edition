package com.webshop.shoppingcart.client.model;

import java.util.List;
import java.util.UUID;

public class Order {

    public String name;
    public List<OrderItem> items;
    public Address address;

    public static class OrderItem {
        public UUID productId;
        public int quantity;
        public float unitPrice;
        public float unitWeight;
    }

    public static class Address {
        String street;
        String city;
        String countryCode;
    }

}
