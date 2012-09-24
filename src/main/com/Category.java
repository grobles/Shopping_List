package com;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 9/22/12
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *             Class: Category
 * Purpose: holds data describing a Category object.
 *
 * @author Lupe Robles, Brian Arnold
 */
public class Category implements InterfaceItems {
    private String categoryName;
    private Shop someShop;

    public Category(String categoryName, Shop someShop) {
        this.categoryName = categoryName;
        this.someShop = someShop;
    }

    /**
     * method: getCategory.
     * @return
     */
    public String getItemName() {
        return categoryName;
    }

    public void setItemName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setSomeShop(Shop someShop) {
        this.someShop = someShop;
    }



    /**
     * method: getShop.
     * @return
     */
    public Shop getShop() {
        return someShop;
    }


}
