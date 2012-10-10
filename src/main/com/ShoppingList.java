package com;

import java.util.Collection;

/**
 * /**
 * Class: ShoppingLists
 * Description: holds data describing a Category object. Each Product will have a shop and a Category
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/10/12
 * Time: 09:50 PM *
 */
public class ShoppingList implements Item {


    private String ShoppingListName;
    Collection<Product> ProductsList;

    /**
     * @param listName
     * @param productsList
     */

    public ShoppingList(String listName, Collection<Product> productsList) {
        this.ShoppingListName = listName;
        this.ProductsList = productsList;

    }

    /**
     * method: getItemName
     *
     * @return
     */

    public String getItemName() {
        return ShoppingListName;
    }

    /**
     * @param shoppingListName
     */

    public void setItemName(String shoppingListName) {
        ShoppingListName = shoppingListName;
    }

    /**
     * method: getProductsList
     */

    public Collection<Product> getProductsList() {
        return ProductsList;
    }

    /**
     * @param productsList
     */

    public void setProductsList(Collection<Product> productsList) {
        ProductsList = productsList;
    }
}
