package com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class: ProductTest
 * Description: Helps test the Product class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 20/09/12
 * Time: 10:12 PM *
 */
public class ProductTest {
    //private data members
    private String itemName, categoryName, shopName;
    private int itemQuantity;
    private Product myMasterShopProduct;
    private Shop aShop;

    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        itemName = "a new item";
        categoryName = "A Category";
        shopName = "New Shop";
        itemQuantity = 10;
        aShop = new Shop(shopName);
        Category aCategory = new Category(categoryName);
        //use the Builder to create a new Product
        myMasterShopProduct = new Product.Builder(itemName, aCategory, aShop).quantity(itemQuantity).unit("pieces").build();
    }

    /**
     * exercise the Product methods
     */
    @Test
    public void testItem() {
        assertEquals("Product Name", itemName, myMasterShopProduct.getItemName());
        assertEquals("Product Category Name", categoryName, myMasterShopProduct.getItemCategory().getItemName());
        assertEquals("Product Quantity", itemQuantity, myMasterShopProduct.getItemQuantity());
    }

    /**
     * test the SetItemName method
     */

    @Test
    public void testSetItemName() {
        myMasterShopProduct.setItemName("new Name");
        assertEquals("Product Name", "new Name", myMasterShopProduct.getItemName());
    }

    /**
     * test the SetItemCategory method
     */

    @Test
    public void testSetItemCategory() {
        Category anotherCategory = new Category("a new category Name");
        myMasterShopProduct.setItemCategory(anotherCategory);
        assertNotEquals("Product Category Name", categoryName, myMasterShopProduct.getItemCategory().getItemName());
    }

    @Test
    public void testSetItemShop() {
        Shop anotherShop = new Shop("a new shop Name");
        myMasterShopProduct.setItemShop(anotherShop);
        assertEquals("Product Shop Name", "a new shop Name", myMasterShopProduct.getItemShop().getItemName());
    }

    @Test
    public void testgetItemUnit() {
        assertEquals("Product Item Unit", "pieces", myMasterShopProduct.getItemUnit());
    }


}

