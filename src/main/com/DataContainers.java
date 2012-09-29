package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class: DataContainers Description: This class will hold all the list from
 * each of the Items. It is a singleton. It will later help to write the
 * information Author: Brian Arnold & Guadalupe Robles Gil Date: 23/09/12 Time:
 * 09:51 PM *
 */
public class DataContainers implements Serializable {

    private static DataContainers ourInstance = new DataContainers();
    private Collection<Product> productList = new ArrayList<Product>();
    private Collection<Category> categoryList = new ArrayList<Category>();
    private Collection<Shop> shopList = new ArrayList<Shop>();
    private static String[] unitsList = new String[]{"", "Pieces", "lb"};
    private Collection<Collection> shoppingLists = new ArrayList<Collection>();

    private DataContainers() {
    }

    /**
     * @return
     */
    public static DataContainers getInstance() {
        return ourInstance;
    }

    /**
     * @return
     */
    public Collection getProductList() {
        return productList;
    }

    /**
     * @return
     */
    public Collection getCategoryList() {
        return categoryList;
    }

    /**
     * @return
     */
    public Collection getShopList() {
        return shopList;
    }

    /**
     * @return
     */
    public Collection<Collection> getShoppingLists() {
        return shoppingLists;
    }

    /**
     * @return
     */
    public String[] getUnitsList() {
        return unitsList;
    }
}


