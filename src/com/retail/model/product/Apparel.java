package com.retail.model.product;

public class Apparel implements Item {

    private int skuId;

    private String name;

    private double price;

    private String size;

    private int quantity;

    public Apparel(int skuId, String name, double price, String size, int quantity) {
        this.skuId = skuId;
        this.name = name;
        this.price = price;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}
