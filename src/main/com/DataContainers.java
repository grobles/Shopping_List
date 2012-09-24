package com;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 09:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataContainers implements Serializable {

    private Lists masterItemLists;
    private Lists categoryLists;
    private Lists shopLists;
    private Collection<Lists> shoppingLists;

    public DataContainers(Lists masterItemLists, Lists categoryLists, Lists shopLists, Collection<Lists> shoppingLists) {
        this.masterItemLists = masterItemLists;
        this.categoryLists = categoryLists;
        this.shopLists = shopLists;
        this.shoppingLists = shoppingLists;
    }

    public Lists getMasterItemLists() {
        return masterItemLists;
    }

    public void setMasterItemLists(Lists masterItemLists) {
        this.masterItemLists = masterItemLists;
    }

    public Lists getCategoryLists() {
        return categoryLists;
    }

    public void setCategoryLists(Lists categoryLists) {
        this.categoryLists = categoryLists;
    }

    public Lists getShopLists() {
        return shopLists;
    }

    public void setShopLists(Lists shopLists) {
        this.shopLists = shopLists;
    }

    public Collection<Lists> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Collection<Lists> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}


