package com;

/**
 * Class: Product
 * Description: This will hold all the Items that we are making lists of: Product , categories , Shops
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 23/09/12
 * Time: 10:13 PM *
 */

public interface Item {
    /**
     * @return
     */
    public String getItemName();

    /**
     * @param itemName
     */
    public void setItemName(String itemName);


    public String toString();

}

