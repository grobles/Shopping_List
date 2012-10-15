package com;

import com.Comparators.ByCategory;
import com.Comparators.ByName;
import com.Persistance.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

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

    private final Product mockProd1 = mock(Product.class);
    private final Product mockProd2 = mock(Product.class);
    private final Product mockProd3 = mock(Product.class);
    private final Category mockCat1 = mock(Category.class);
    private final Category mockCat2 = mock(Category.class);
    private final Category mockCat3 = mock(Category.class);
    private Collection<Product> someArray = new ArrayList<Product>();
    RecordSeeker recordSeekerProduct;
    Collection<Product> arrayToSort;


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {

        arrayToSort = new ArrayList<Product>();
        recordSeekerProduct = new RecordSeeker("Product");
        someArray.add(mockProd1);
        someArray.add(mockProd2);
        someArray.add(mockProd3);


    }

    /**
     * exercise the Lists methods
     */
    @Test
    public void testSortList() {
        Comparator sort = new ByName();
        when(mockProd2.getItemName()).thenReturn("Alpha");
        when(mockProd1.getItemName()).thenReturn("Beta");
        when(mockProd3.getItemName()).thenReturn("Gamma");
        someArray = recordSeekerProduct.Sort(someArray, sort);
        String first = someArray.iterator().next().getItemName();
        assertEquals("First Name ", "Alpha", first);

    }

    @Test
    public void testSortListByCategory() {
        Comparator sort = new ByCategory();
        when(mockProd1.getItemCategory()).thenReturn(mockCat1);
        when(mockProd2.getItemCategory()).thenReturn(mockCat2);
        when(mockProd3.getItemCategory()).thenReturn(mockCat3);
        when(mockCat2.getItemName()).thenReturn("Alpha");
        when(mockCat1.getItemName()).thenReturn("Beta");
        when(mockCat3.getItemName()).thenReturn("Gamma");
        someArray = recordSeekerProduct.Sort(someArray, sort);
        String first = someArray.iterator().next().getItemCategory().getItemName();
        assertEquals("First name ", "Alpha", first);

    }

    /**
     *
     */


    @Test
    public void testFindProduct() {

        recordSeekerProduct.addItem(mockProd1);
        recordSeekerProduct.addItem(mockProd2);
        when(mockProd2.getItemName()).thenReturn("Alpha");
        when(mockProd1.getItemName()).thenReturn("Beta");
        String nameOfItem = recordSeekerProduct.findItem("Alpha").getItemName();
        assertEquals("Name ", "Alpha", nameOfItem);

    }

    @Test
    public void testDeleteProduct() {

        recordSeekerProduct.addItem(mockProd1);
        recordSeekerProduct.addItem(mockProd2);
        when(mockProd2.getItemName()).thenReturn("Alpha");
        when(mockProd1.getItemName()).thenReturn("Beta");
        int productsize = recordSeekerProduct.getList().size();
        Product product = (Product) recordSeekerProduct.findItem("Alpha");
        recordSeekerProduct.deleteProduct(product);
        int newproductsize = recordSeekerProduct.getList().size();
        assertEquals("Size ", productsize - 1, newproductsize);


    }


}