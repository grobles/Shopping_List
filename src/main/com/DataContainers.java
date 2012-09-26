package com;

import java.io.Serializable;
import java.util.Collection;


//todo provide documentation here

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 09:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataContainers implements Serializable {

    private Lists masterItemList;
    private Lists categoryList;
    private Lists shopList;
    private Collection<Lists> shoppingLists;

    public DataContainers(Lists masterItemLists, Lists categoryLists, Lists shopLists, Collection<Lists> shoppingLists) {
        this.masterItemList = masterItemLists;
        this.categoryList = categoryLists;
        this.shopList = shopLists;
        this.shoppingLists = shoppingLists;
    }

    public Lists getMasterItemList() {
        return masterItemList;
    }

    public void setMasterItemList(Lists masterItemList) {
        this.masterItemList = masterItemList;
    }

    public Lists getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Lists categoryList) {
        this.categoryList = categoryList;
    }

    public Lists getShopList() {
        return shopList;
    }

    public void setShopList(Lists shopList) {
        this.shopList = shopList;
    }

    public Collection<Lists> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Collection<Lists> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}


