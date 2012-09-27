package com;

/**
 * Class: Category
 * Description: holds data describing a Category object. Each Product will have a shop and a Category
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */

public class Category implements Item {
    private String categoryName;
    private Shop someShop;

    /**
     * @param categoryName
     * @param someShop
     */
    public Category(String categoryName, Shop someShop) {
        this.categoryName = categoryName;
        this.someShop = someShop;
    }

    /**
     * method: getCategory.
     *
     * @return
     */
    public String getItemName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setItemName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @param someShop
     */
    public void setSomeShop(Shop someShop) {
        this.someShop = someShop;
    }


    /**
     * method: getShop.
     *
     * @return
     */
    public Shop getShop() {
        return someShop;
    }


}
