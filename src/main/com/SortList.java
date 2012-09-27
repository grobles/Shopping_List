package com;

/**
 * Class: ByName
 * Description: It will help to sort the list by name. To be used in a TreeSet
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 25/09/12
 * Time: 12:19 PM *
 */

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class SortList {

    public static Collection<Item> Sort(Collection<Item> list) {

        Collection ListSorted = new TreeSet(new ByName());
        for (Item item : list) {
            ListSorted.add(item);
        }


        return ListSorted;


    }
}

class ByName implements Comparator {

    public int compare(Object o1, Object o2) {
        Item item1 = (Item) o1;
        Item item2 = (Item) o2;

        return item1.getItemName().compareTo(item2.getItemName());
    }


}


