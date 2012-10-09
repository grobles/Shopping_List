package com.Comparators;

import com.Product;

import java.util.Comparator;

/**
 * Class:
 * Description:
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/10/12
 * Time: 12:52 PM *
 */
public class ByShop implements Comparator {

    public int compare(Object o1, Object o2) {
        Product product1 = (Product) o1;
        Product product2 = (Product) o1;

        return product1.getItemShop().getItemName().compareTo(product2.getItemShop().getItemName());
    }
}
