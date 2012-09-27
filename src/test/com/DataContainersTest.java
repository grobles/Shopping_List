package com;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    private final Collection<Item> mockCollectionItems = mock(Collection.class);
    private final Collection mockCollectionCategory = mock(Collection.class);
    private final Collection mockCollectionShops = mock(Collection.class);
    private final Collection mockCollectionShopping1 = mock(Collection.class);
    private final Collection mockCollectionShopping2 = mock(Collection.class);
    ArrayList<Collection> someArray = new ArrayList<Collection>();


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        someArray.add(mockCollectionShopping1);
        someArray.add(mockCollectionShopping2);


    }


    /**
     * exercise the DataContainers methods
     */
    @Test

    public void testConstruction() {

        when(mockCollectionItems.size()).thenReturn(2);
        DataContainers someDc = new DataContainers(mockCollectionItems, mockCollectionCategory, mockCollectionShops, someArray);
        int arraySize = someDc.getProductList().size();
        assertEquals("size ", arraySize, 2);
    }


}
