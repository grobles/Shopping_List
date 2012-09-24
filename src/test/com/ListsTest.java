package com;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */

/*  TODO the test , this is not the test I still have to work on it.
    */

public class ListsTest {
    //private data members
    private String itemName, categoryName, shopName;
    private int itemQuantity;
    private Item myItem;
    private Category aCategory;
    private Shop aShop;

    /**
     * setup the Item to test
     */
    @Before
    public void setup() {
        itemName = "a new item";
        categoryName = "A Category";
        shopName = "New Shop";
        itemQuantity = 10;
        aShop= new Shop(shopName);
        aCategory= new Category(categoryName, aShop);
        //use the Builder to create a new Item
        myItem = new Item(itemName, aCategory, aShop ,itemQuantity);
    }

    /**
     * exercise the Item methods
     */
    @Test
    public void testItem() {

        assertEquals("Item Name" ,itemName, myItem.getItemName());
        assertEquals("Item Category Name", categoryName, myItem.getItemCategory().getItemName());
        assertEquals("Item Shop Name", shopName, myItem.getItemShop().getItemName());
        assertEquals("Item Quantity", itemQuantity, myItem.getItemQuantity());
    }


}
