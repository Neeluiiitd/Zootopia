package org.example;

import java.util.Map;

import static org.example.zoo.dictionary_arractions;
import static org.example.zoo.dictionary_discounts;

public class Discount {


    private double discount_percentge;


    public Discount(double discount) {
        this.discount_percentge = discount;

    }

    public double getDiscount() {
        return discount_percentge;
    }


    static void add_discount(String num,Discount a1){
        dictionary_discounts.put(num,a1);

    }
    static void remove_discount(String num) {
        dictionary_arractions.remove(num);
    }

    public static double getDiscountPercentage(String category) {

        Discount d1 = dictionary_discounts.get(category);
        if (d1!= null) {
            return d1.getDiscount();
        }

        return 0.0;
    }
    public static void showDiscounts() {
        for (Map.Entry<String, Discount> entry : dictionary_discounts.entrySet()) {
            String category = entry.getKey();
            Discount discount = entry.getValue();
            System.out.println("coupon: " + category + ", Discount Percentage: " + discount.getDiscount());
        }
    }



}
