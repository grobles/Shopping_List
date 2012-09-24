package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 20/09/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */

/*  TODO more methods
    */

public class DataContainersTest {
    //private data members
    Lists mockListsItems = mock(Lists.class);
    Lists mockListsCategory = mock(Lists.class);
    Lists mockListsShops = mock(Lists.class);
    Lists mockListsShopping1 = mock(Lists.class);
    Lists mockListsShopping2 = mock(Lists.class);
    ArrayList<Lists> someArray = new ArrayList<Lists>();



    /**
     * setup the Item to test
     */
    @Before
    public void setup() {
        someArray.add(mockListsShopping1);
        someArray.add(mockListsShopping2);


    }


    /**
     * exercise the DataContainers methods
     */
    @Test

    public void testConstruction() {

        when(mockListsItems.getSize()).thenReturn(2);
        DataContainers someDc = new DataContainers(mockListsItems,mockListsCategory,mockListsShops,someArray);
        int arraySize = someDc.getMasterItemList().getSize();


        assertEquals("size ", arraySize, 2);
    }


}
