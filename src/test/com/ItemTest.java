package com;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemTest {
    //private data members
    private String itemName, categoryName, shopName;
    private int itemQuantity;
    private Item myItem;
    private Category aCategory = new Category();
    private Shop aShop = new Shop();

    /**
     * setup the Item to test
     */
    @Before
    public void setup() {
        itemName = "a new item";
        categoryName = "A Category";
        shopName = "New Shop";
        itemQuantity = 10;
        aShop.setShopName(shopName);
        aCategory.setCategory(categoryName, shopName);
        //use the Builder to create a new Item
        myItem = new Item.Builder(itemName, aCategory, aShop).quantity(itemQuantity).build();
    }

    /**
     * exercise the Item methods
     */
    @Test
    public void testItem() {
        assertEquals("Item Name", itemName, myItem.getItemName());
        assertEquals("Item Category Name", categoryName, myItem.getItemCategory());
        assertEquals("Item Shop Name", shopName, myItem.getItemShop());
        assertEquals("Item Quantity", itemQuantity, myItem.getItemQuantity());
    }
}
