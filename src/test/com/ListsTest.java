package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */



public class ListsTest {
    //private data members
    InterfaceItems mockItem1 = mock(InterfaceItems.class);
    InterfaceItems mockItem2 = mock(InterfaceItems.class);
    InterfaceItems mockItem3 = mock(InterfaceItems.class);
    ArrayList<InterfaceItems> someArray = new ArrayList<InterfaceItems>();



    /**
     * setup the Item to test
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

    public void testConstruction() {

        Lists someLists = new Lists(someArray);
        int arraySize = someArray.size();
        int ListsSize = someLists.getSize();

        assertEquals("size ", arraySize, ListsSize);
    }
    @Test
    public void testRemoveItem(){

        Lists someLists = new Lists(someArray);
        someLists.removeItem(mockItem1);
        int ListsSize = someLists.getSize();

        assertEquals("size ", 2, ListsSize);

    }
    @Test
    public void testAddItem(){

        Lists someLists = new Lists(someArray);
        someLists.addItem(mockItem1);
        int ListsSize = someLists.getSize();

        assertEquals("size ", 4, ListsSize);

    }

}
