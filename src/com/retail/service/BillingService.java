package com.retail.service;

import com.retail.model.Bill;
import com.retail.model.User;
import com.retail.model.product.Item;
import com.retail.util.DiscountHelper;

import java.util.List;

public class BillingService {

    private User user;

    private List<Item> items;

    public BillingService(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public Bill calculate() {
        return DiscountHelper.calculateDiscount(user, items);
    }
}
