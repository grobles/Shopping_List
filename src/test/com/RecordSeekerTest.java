package com;

import com.Persistance.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    private final Category mockCat1 = mock(Category.class);
    private final Category mockCat2 = mock(Category.class);
    private final Shop mockShop1 = mock(Shop.class);
    RecordSeeker recordSeeker;


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {

        recordSeeker = new RecordSeeker("dataTest.xml");


    }

    /**
     * exercise the Lists methods
     */

    @Test
    public void testSetStringArray() {
        List<Item> newArray = recordSeeker.getProductList();
        int sizeNewArray = newArray.size();
        String[] otherArray = recordSeeker.setStringArray(newArray);
        int otherArraySize = otherArray.length;
        assertEquals("Size ", sizeNewArray, otherArraySize);


    }

    /**
     *
     */
    @Test
    public void testFindProduct() {

        recordSeeker.addItem(mockProd1, "Product");
        recordSeeker.addItem(mockProd2, "Product");
        when(mockProd2.getItemName()).thenReturn("Alpha");
        when(mockProd1.getItemName()).thenReturn("Beta");
        String nameOfItem = recordSeeker.findItem("Alpha", "product").getItemName();
        assertEquals("Name ", "Alpha", nameOfItem);

    }

    /**
     *
     */
    @Test
    public void testFindShop() {

        recordSeeker.addItem(mockShop1, "Shop");
        when(mockShop1.getItemName()).thenReturn("Alpha");
        String nameOfItem = recordSeeker.findItem("Alpha", "Shop").getItemName();
        assertEquals("Name ", "Alpha", nameOfItem);

    }

    /**
     *
     */
    @Test
    public void testGetUnitsList() {

        String[] unitsList = recordSeeker.getUnitsList();
        int unitsListSize = unitsList.length;
        assertEquals("Size ", 3, unitsListSize);

    }

    /**
     *
     */
    @Test
    public void testDeleteProduct() {

        recordSeeker.addItem(mockCat1, "Category");
        recordSeeker.addItem(mockCat2, "Category");
        when(mockCat2.getItemName()).thenReturn("Alpha");
        when(mockCat1.getItemName()).thenReturn("Beta");
        int catsize = recordSeeker.getcategoryList().size();
        Category category = (Category) recordSeeker.findItem("Alpha", "Category");
        recordSeeker.deleteProduct(category, "Category");
        int newCatSize = recordSeeker.getcategoryList().size();
        assertEquals("Size ", catsize - 1, newCatSize);


    }


}