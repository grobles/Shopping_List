package com;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 9/22/12
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *             Class: Shop
 * Purpose: holds data describing a shop object
 *
 * @author Lupe Robles, Brian Arnold
 *
 */
public class Shop implements InterfaceItems {
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    /**
     * method: setShopName.
     * @param shopName
     *
     */


    public void setItemName(String shopName) {
        this.shopName = shopName;
    }
    /**
     * method: getShopName.
     * @return
     */
    public String getItemName() {
        return shopName;
    }
}
