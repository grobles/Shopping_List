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
public class Category {
    private String categoryName;
    private Shop someShop = new Shop();

    /**
     * method: setCategory.
     * @param categoryName
     * @param shopName
     */
    public void setCategory(String categoryName, String shopName) {
        this.categoryName = categoryName;
        someShop.setShopName(shopName);
    }

    /**
     * method: getCategory.
     * @return
     */
    public String getCategory() {
        return categoryName;
    }

    /**
     * method: getShop.
     * @return
     */
    public String getShop() {
        return someShop.getShopName();
    }
}
