package com;

import com.Persistance.DataContainers;
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
    private final ShoppingList mockShoppingList = mock(ShoppingList.class);


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {

        DataContainers someDc = DataContainers.getInstance();


    }


    /**
     * exercise the DataContainers methods
     */
    @Test

    public void testConstruction() {
        DataContainers someDc = DataContainers.getInstance();
        someDc.getShoppingLists().add(mockShoppingList);
        someDc.getShoppingLists().add(mockShoppingList);
        someDc.getProductList().add(mockProduct);
        someDc.getProductList().add(mockProduct2);

        someDc.getCategoryList().add(mockCategory);
        someDc.getShopList().add(mockShop);
        int productSize = someDc.getProductList().size();
        assertEquals("size ", productSize, 2);
        int categorySize = someDc.getCategoryList().size();
        assertEquals("size ", categorySize, 1);
        int shopSize = someDc.getShopList().size();
        assertEquals("size ", shopSize, 1);
        int unitslistSize = someDc.getUnitsList().length;
        assertEquals("size ", unitslistSize, 3);
    }


    @Test

    public void testSetShoppingLists() {
        DataContainers someDc = DataContainers.getInstance();
        ArrayList<ShoppingList> newList = new ArrayList<ShoppingList>();
        newList.add(mockShoppingList);
        someDc.setShoppingLists(newList);
        int size = someDc.getShoppingLists().size();
        assertEquals("size ", size, 1);

    }


}
