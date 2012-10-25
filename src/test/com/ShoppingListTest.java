package com;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Class:
 * Description:
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/10/12
 * Time: 09:56 PM *
 */
public class ShoppingListTest {

    private final Product mockProduct = mock(Product.class);
    private final Product mockProduct2 = mock(Product.class);
    private final String ListName = "newShoppingList";
    private final List<Product> ProductList = new ArrayList<Product>();
    private ShoppingList newList;


    @Before
    public void setUp() throws Exception {


        ProductList.add(mockProduct);
        ProductList.add(mockProduct2);
        newList = new ShoppingList(ListName, ProductList);
    }

    /**
     * exercise the ShoppingList methods.
     */

    @Test
    public void testConstructor() throws Exception {


        String name = newList.getItemName();
        int size = newList.getProductsList().size();
        assertEquals("List Name", "newShoppingList", name);
        assertEquals("List size", 2, size);

    }

    @Test
    public void testSetItemName() {
        newList.setItemName("Shop2");
        Assert.assertEquals("Shop Name", "Shop2", newList.getItemName());

    }

    @Test
    public void testSetProductList() {
        List<Product> newProductList = ProductList;
        newProductList.add(mockProduct);
        newList.setProductsList(newProductList);
        int size = newList.getProductsList().size();
        Assert.assertEquals("Product size", size, 3);

    }
}
