package com.Comparators;

import com.Item;

import java.util.Comparator;

/**
 * Class: ByName
 * Description:This Class will help to sort Items By Name
 * Author: Brian Arnold & Guadalupe Robles Gil Date: 9/10/12
 * Time: 12:52 PM *
 */
public class ByName implements Comparator {

    // todo - javadoc comment how things are compared.

    /**
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Object o1, Object o2) {
        Item item1 = (Item) o1;
        Item item2 = (Item) o2;

        return item1.getItemName().compareTo(item2.getItemName());
    }
}
