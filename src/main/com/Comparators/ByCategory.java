package com.Comparators;

import com.Product;

import java.util.Comparator;

/**
 * Class: Description: Author: Brian Arnold & Guadalupe Robles Gil Date: 9/10/12
 * Time: 12:52 PM *
 */
public class ByCategory implements Comparator {

    /**
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Object o1, Object o2) {
        Product product1 = (Product) o1;
        Product product2 = (Product) o2;
        String category1 = product1.getItemCategory().getItemName();
        String category2 = product2.getItemCategory().getItemName();

        return category1.compareTo(category2);
    }
}
