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

    private final Product mockItem1 = mock(Product.class);
    private final Product mockItem2 = mock(Product.class);
    private final Product mockItem3 = mock(Product.class);
    private ArrayList<Item> someArray = new ArrayList<Item>();
    RecordSeeker recordSeekerProduct ;
    DataContainers dc;
    Collection<Item> arrayToSort;



    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        someArray = new ArrayList<Item>();
        arrayToSort = new ArrayList<Item>();
        recordSeekerProduct = new RecordSeeker("Product");





    }

    /**
     * exercise the Lists methods
     */
    @Test
    public void testSortList() {

        someArray.add(mockItem1);
        someArray.add(mockItem2);
        someArray.add(mockItem3);
        when(mockItem3.getItemName()).thenReturn("Alpha");
        when(mockItem2.getItemName()).thenReturn("Beta");
        when(mockItem1.getItemName()).thenReturn("Gamma");
        arrayToSort = recordSeekerProduct.Sort(someArray);
        String first = arrayToSort.iterator().next().getItemName();
        assertEquals("size ", "Alpha", first);

    }

    /**
     *
     */
    @Test
    public void testSortListFromDc() {
        dc = DataContainers.getInstance();
        recordSeekerProduct.addItem(mockItem1);
        recordSeekerProduct.addItem(mockItem2);
        Collection<Item> arrayToSort2 = recordSeekerProduct.getList();
        when(mockItem2.getItemName()).thenReturn("Alpha");
        when(mockItem1.getItemName()).thenReturn("Beta");
        arrayToSort = recordSeekerProduct.Sort(arrayToSort2);
        String first = arrayToSort.iterator().next().getItemName();
        assertEquals("size ", "Alpha", first);

    }

    @Test
    public void testFindProduct() {
        dc = DataContainers.getInstance();
        recordSeekerProduct.addItem(mockItem1);
        recordSeekerProduct.addItem(mockItem2);
        when(mockItem2.getItemName()).thenReturn("Alpha");
        when(mockItem1.getItemName()).thenReturn("Beta");
        String nameOfItem = recordSeekerProduct.findItem("Alpha").getItemName();
        assertEquals("Name ", "Alpha", nameOfItem);

}

    @Test
    public void testDeleteProduct() {

        dc = DataContainers.getInstance();
        recordSeekerProduct.addItem(mockItem1);
        recordSeekerProduct.addItem(mockItem2);
        when(mockItem2.getItemName()).thenReturn("Alpha");
        when(mockItem1.getItemName()).thenReturn("Beta");
        int productsize = recordSeekerProduct.getList().size();
        assertEquals("Size ", 5, productsize);
        Product product = (Product)recordSeekerProduct.findItem("Alpha");
        recordSeekerProduct.deleteProduct(product);
        productsize = recordSeekerProduct.getList().size();
        assertEquals("Size ", 4, productsize);




         }


}