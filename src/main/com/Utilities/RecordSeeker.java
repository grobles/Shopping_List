package com.Utilities;

import com.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Class: Product
 * Description: This will hold all the Items that we are making lists of: Product , categories , Shops
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 10:13 PM *
 */

/**
 * Class: Record Seeker Description: This class with hold the code needed to get
 * records from the container. It will help sort the records , get specific data
 * etc.. Author: Brian Arnold & Guadalupe Robles Gil Date: 27/09/12 Time: 08:11
 * PM *
 */
public class RecordSeeker {

    private static DataContainers dc = DataContainers.getInstance();
    private static Collection<Product> productList = dc.getProductList();
    private static Collection<Category> categoryList = dc.getCategoryList();
    private static Collection<Shop> shopList = dc.getShopList();

    /**
     * method: findProduct  Given the name it returns an Item
     *
     * @param itemName
     *
     * @return
     */
    public static Product findProduct(String itemName) {
        Product itemFound = null;

        for (Product item : productList) {
            if (item.getItemName().equals(itemName)) {
                itemFound = item;
            }

        }
        return itemFound;
    }

    /**
     * @param itemName
     *
     * @return
     */
    public static Category findCategory(String itemName) {
        Category itemFound = null;

        for (Category item : categoryList) {
            if (item.getItemName().equals(itemName)) {
                itemFound = item;
            }

        }
        return itemFound;
    }

    /**
     * @param itemName
     *
     * @return
     */
    public static Shop findShop(String itemName) {
        Shop itemFound = null;

        for (Shop item : shopList) {
            if (item.getItemName().equals(itemName)) {
                itemFound = item;
            }

        }
        return itemFound;
    }

    /**
     * method: makeCombo It helps make the String[] needed for the combos in the different forms
     *
     * @param List
     *
     * @return
     */
    public static String[] makeCombo(Collection<Item> List) {
        int size = List.size();
        String[] comboArray = new String[size];
        int i = 0;
        Iterator iterator = List.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            String name = item.getItemName();
            comboArray[i] = name;
            i++;
        }
        return comboArray;
    }

    /**
     * method: sort This method will help sort by Name the different lists
     *
     * @param list
     *
     * @return
     */
    public static Collection<Item> Sort(Collection<Item> list) {

        Collection ListSorted = new TreeSet(new ByName());
        for (Item item : list) {
            ListSorted.add(item);
        }


        return ListSorted;


    }
}

/**
 * Class: ByName
 * Description: This will be the class used in the TreeSet to sort By Name
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 10:13 PM *
 */

class ByName implements Comparator {

    public int compare(Object o1, Object o2) {
        Item item1 = (Item) o1;
        Item item2 = (Item) o2;

        return item1.getItemName().compareTo(item2.getItemName());
    }
}