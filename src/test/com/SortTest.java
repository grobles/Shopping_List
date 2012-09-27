package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM *
 */

public class SortTest {
    //private data members
    private final Item mockItem1 = mock(Item.class);
    private final Item mockItem2 = mock(Item.class);
    private final Item mockItem3 = mock(Item.class);
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

        Collection<Item> arrayToSort = new ArrayList(someArray);
        when(mockItem3.getItemName()).thenReturn("Alpha");
        when(mockItem2.getItemName()).thenReturn("Beta");
        when(mockItem1.getItemName()).thenReturn("Gamma");
        arrayToSort = SortList.Sort(arrayToSort);
        String first = arrayToSort.iterator().next().getItemName();
        assertEquals("size ", "Alpha", first);

    }


}

