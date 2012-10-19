package com.Persistance;

import com.Category;
import com.Product;
import com.Shop;
import com.ShoppingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: DataContainers Description: This class will hold all the list from
 * each of the Items. It is a singleton. It will later help to write the
 * information Author: Brian Arnold & Guadalupe Robles Gil Date: 23/09/12 Time:
 * 09:51 PM *
 */
public class DataContainers {

    private static DataContainers ourInstance = new DataContainers();
    private List<Product> productList = new ArrayList<Product>();
    private List<Category> categoryList = new ArrayList<Category>();
    private List<Shop> shopList = new ArrayList<Shop>();
    private static String[] unitsList = new String[]{"", "Pieces", "lb"};
    private List<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

    private DataContainers() {
    }

    /**
     * @return
     */
    static DataContainers getInstance() {
        return ourInstance;
    }

    /**
     * @return
     */
    List getProductList() {
        return productList;
    }

    /**
     * @return
     */
    List getCategoryList() {
        return categoryList;
    }

    /**
     * @return
     */
    List getShopList() {
        return shopList;
    }

    /**
     * @return
     */
    List getShoppingLists() {
        return shoppingLists;
    }

    /**
     * @return
     */
    String[] getUnitsList() {
        return unitsList;
    }

    /**
     * @param productList
     */
    void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @param categoryList
     */
    void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * @param shopList
     */
    void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    /**
     * @param shoppingLists
     */
    void setShoppingLists(List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}
