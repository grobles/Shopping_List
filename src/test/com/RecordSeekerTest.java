package com;

import com.Utilities.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class: RecordSeekerTest
 * Description: Helps test the RecordSeeker class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 20/09/12
 * Time: 10:12 PM
 */
public class RecordSeekerTest {
    //private data members

    private final Item mockItem1 = mock(Item.class);
    private final Item mockItem2 = mock(Item.class);
    private final Item mockItem3 = mock(Item.class);
    private final Item mockProduct = mock(Product.class);
    private final Item mockProduct2 = mock(Product.class);
    private final ArrayList<Item> someArray = new ArrayList<Item>();

    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        someArray.add(mockItem1);
        someArray.add(mockItem2);
        someArray.add(mockItem3);

    }

    /**
     * exercise the Lists methods
     */
    @Test
    public void testSortList() {

        Collection<Item> arrayToSort = new ArrayList<Item>(someArray);
        when(mockItem3.getItemName()).thenReturn("Alpha");
        when(mockItem2.getItemName()).thenReturn("Beta");
        when(mockItem1.getItemName()).thenReturn("Gamma");
        arrayToSort = RecordSeeker.Sort(arrayToSort);
        String first = arrayToSort.iterator().next().getItemName();
        assertEquals("size ", "Alpha", first);

    }

    /**
     *
     */
    @Test
    public void testSortListFromDC() {

        DataContainers someDc = DataContainers.getInstance();
        someDc.getProductList().add(mockProduct);
        someDc.getProductList().add(mockProduct2);
        Collection<Item> arrayToSort = someDc.getProductList();
        when(mockProduct2.getItemName()).thenReturn("Alpha");
        when(mockProduct.getItemName()).thenReturn("Beta");
        arrayToSort = RecordSeeker.Sort(arrayToSort);
        String first = arrayToSort.iterator().next().getItemName();
        assertEquals("size ", "Alpha", first);

    }
}