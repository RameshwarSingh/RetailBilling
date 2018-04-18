package com.retail.model.product;

public class Grocery implements Item {

    private int skuId;

    private String name;

    private double price;

    private float quantity;

    public Grocery(int skuId, String name, double price, float quantity) {
        this.skuId = skuId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public int getSkuId() {
        return skuId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public float getQuantity() {
        return quantity;
    }
}
