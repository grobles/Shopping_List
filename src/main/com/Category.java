package com;

import java.io.Serializable;

/**
 * Class: Category
 * Description: holds data describing a Category object. Each Product will have a shop and a Category
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:51 PM *
 */

public class Category implements Item, Serializable {
    private String categoryName;

    /**
     * @param categoryName
     * @param
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;

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
        /**
     * method: getShop.
     *
     * @return
     */

}
