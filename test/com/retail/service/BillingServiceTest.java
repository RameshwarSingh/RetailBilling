
package com.retail.service;

import com.retail.model.Bill;
import com.retail.model.User;
import com.retail.model.product.Apparel;
import com.retail.model.product.Grocery;
import com.retail.model.product.Item;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillingServiceTest {

    private static User user;
    private static List<Item> items = new ArrayList<>();
    private static BillingService billingService;

    @BeforeClass
    public static void init() {

        items.add(new Apparel(11, "T-Shirt", 300.0, "M", 1));
        items.add(new Apparel(12, "Jeans", 500.0, "32", 1));
        items.add(new Grocery(13, "Mango", 200.0, 5));
        items.add(new Grocery(14, "Apple", 300.0, 5));
    }

    @Test
    public void testBillAmount() {
        user = new User(1, "Peter", LocalDateTime.now(), User.UserType.CUSTOMER);
        billingService = new BillingService(user, items);

        Bill bill = billingService.calculate();
        Assert.assertEquals(bill.getBillAmount(), 1235, 0);
    }

    @Test
    public void testBillAmountForEmployee() {
        user = new User(2, "Sam", LocalDateTime.now(), User.UserType.EMPLOYEE);
        billingService = new BillingService(user, items);

        Bill bill = billingService.calculate();
        Assert.assertEquals(bill.getBillAmount(), 1010, 0);
    }

    @Test
    public void testBillAmountForAffliate() {
        user = new User(4, "Sam", LocalDateTime.now(), User.UserType.AFFILIATE);
        billingService = new BillingService(user, items);

        Bill bill = billingService.calculate();
        Assert.assertEquals(bill.getBillAmount(), 1160, 0);
    }

    @Test
    public void testBillAmountForOldCustomer() {
        user = new User(5, "Sam", LocalDateTime.now().minusYears(3), User.UserType.CUSTOMER);
        billingService = new BillingService(user, items);

        Bill bill = billingService.calculate();
        Assert.assertEquals(bill.getBillAmount(), 1200, 0);
    }
}
