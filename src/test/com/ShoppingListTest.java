package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

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
    private final String ListName = new String("newShoppingList");
    Collection<Product> shoppingList = new ArrayList<Product>();


    @Before
    public void setUp() throws Exception {


        shoppingList.add(mockProduct);
        shoppingList.add(mockProduct2);

    }

    /**
     * exercise the ShoppingList methods.
     */

    @Test
    public void testConstructor() throws Exception {

        ShoppingList newList = new ShoppingList(ListName, shoppingList);
        String name = newList.getItemName();
        int size = newList.getProductsList().size();
        assertEquals("List Name", "newShoppingList", name);
        assertEquals("List size", 2, size);

    }
}
