package com.retail.util;

import com.retail.model.Bill;
import com.retail.model.User;
import com.retail.model.product.Apparel;
import com.retail.model.product.Grocery;
import com.retail.model.product.Item;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountHelper {

    private DiscountHelper() {}

    public static Bill calculateDiscount(User user, List<Item> items) {

        double nonGrocerySum = items.stream().filter(item -> !(item instanceof Grocery)).collect(Collectors.summingDouble(Item::getPrice));
        Bill percentDiscountAmt = caclulatePercentDiscount(user, nonGrocerySum);

        double grocerySum = items.stream().filter(item -> item instanceof Grocery).collect(Collectors.summingDouble(Item::getPrice));

        double totalSum = percentDiscountAmt.getBillAmount() + grocerySum;
        int discount = (int)(totalSum / 100) * 5;
        totalSum = totalSum - discount;

        return new Bill(totalSum, percentDiscountAmt.getDiscount() + discount);
    }

    private static Bill caclulatePercentDiscount(User user, double amount) {
        double dicountedAmt = amount;
        double discount = 0;
        if(User.UserType.EMPLOYEE.equals(user.getUserType())) {
            discount = amount * 30/100;
            dicountedAmt = amount - discount;
        } else if(User.UserType.AFFILIATE.equals(user.getUserType())) {
            discount = amount*10/100;
            dicountedAmt = amount - discount;
        } else if(user.getRegistrationDate().isBefore(LocalDateTime.now().minusYears(2))) {
            discount = amount*5/100;
            dicountedAmt = amount - discount;
        }
        return new Bill(dicountedAmt, discount);
    }

}
