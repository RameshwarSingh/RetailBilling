package com.retail.model;

public class Bill {

    private double billAmount;

    private double discount;

    public Bill(double billAmount, double discount) {
        this.billAmount = billAmount;
        this.discount = discount;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public double getDiscount() {
        return discount;
    }
}
