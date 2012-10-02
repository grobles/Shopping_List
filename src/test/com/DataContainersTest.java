package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Class: DataContainersTest
 * Description: Helps test the DataContainers class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 20/09/12
 * Time: 10:12 PM *
 */
/*
    */

public class DataContainersTest {
    //private data members
    private final Item mockProduct = mock(Product.class);
    private final Item mockProduct2 = mock(Product.class);
    private final Item mockCategory = mock(Category.class);
    private final Item mockShop = mock(Shop.class);
    private final ArrayList mockCollectionShopping1 = mock(ArrayList.class);
    private final ArrayList mockCollectionShopping2 = mock(ArrayList.class);
    DataContainers someDc = DataContainers.getInstance();


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        someDc.getShoppingLists().add(mockCollectionShopping1);
        someDc.getShoppingLists().add(mockCollectionShopping2);
        someDc.getProductList().add(mockProduct);
        someDc.getProductList().add(mockProduct2);
        someDc.getCategoryList().add(mockCategory);
        someDc.getShopList().add(mockShop);

    }


    /**
     * exercise the DataContainers methods
     */
    @Test

    public void testConstruction() {
        DataContainers anotherDc = DataContainers.getInstance();

        int productSize = anotherDc.getProductList().size();
        assertEquals("size ", productSize, 2);
        int categorySize = anotherDc.getCategoryList().size();
        assertEquals("size ", categorySize, 1);
        int shopSize = anotherDc.getShopList().size();
        assertEquals("size ", shopSize, 1);
        int shoppinglistSize = anotherDc.getShoppingLists().size();
        assertEquals("size ", shoppinglistSize, 2);
    }


}
