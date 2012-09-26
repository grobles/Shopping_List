package com;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 23/09/12
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *             Class: InterfaceItems
 * Purpose: This will hold all the Items that we are making lists of: Item , categories , Shops
 *
 * @author Lupe Robles, Brian Arnold
 *
 */

public interface InterfaceItems {         // todo - this is a bad name. Just use the word Item. then concrete classes can be called StoreItem or something else specific



    /**
     *
     * @return
     */
    public String getItemName();
    /**
     *
     * @param itemName
     */
    public void setItemName(String itemName);

    public String toString();




}

