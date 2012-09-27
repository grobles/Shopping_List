package com;

/**
 * Class: Product
 * Description: holds data describing a Shop object. Each Product will have a shop and a Category
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:53 PM *
 */

public class Shop implements Item {
    private String shopName;

    /**
     * @param shopName
     */
    public Shop(String shopName) {
        this.shopName = shopName;
    }

    /**
     * method: setShopName.
     *
     * @param shopName
     */


    public void setItemName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * method: getShopName.
     *
     * @return
     */
    public String getItemName() {
        return shopName;
    }
}
