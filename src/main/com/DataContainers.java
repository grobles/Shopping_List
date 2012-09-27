package com;

import java.io.Serializable;
import java.util.Collection;


//todo provide documentation here

/**
 * Class: DataContainers
 * Description: This class will hold all the list from each of the Items.
 * It will later help to write the information
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 09:51 PM *
 */
public class DataContainers implements Serializable {

    private Collection<Item> productList;
    private Collection<Item> categoryList;
    private Collection<Item> shopList;
    private static String[] unitsList ;
    private Collection<Collection> shoppingLists;

    public DataContainers(Collection productList, Collection categoryList, Collection shopList, Collection<Collection> shoppingLists) {
        this.productList = productList;
        this.categoryList = categoryList;
        this.shopList = shopList;
        this.shoppingLists = shoppingLists;
        String[] unitsList={"Pieces" , "lb"};

    }

    public Collection getProductList() {
        return productList;
    }

    public void setProductList(Collection productList) {
        this.productList = productList;
    }

    public Collection getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Collection category) {
        this.categoryList = categoryList;
    }

    public Collection getShopList() {
        return shopList;
    }

    public void setShopList(Collection shopList) {
        this.shopList = shopList;
    }

    public Collection<Collection> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Collection<Collection> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public String[] getunitsLists() {
        return unitsList;
    }
}


