package com;

import com.Comparators.ByCategory;
import com.Comparators.ByName;
import com.Comparators.ByShop;
import com.Persistance.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: grobles
 * Date: 17/10/12
 * Time: 06:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComparatorsTest {
    private final Product mockProd1 = mock(Product.class);
    private final Product mockProd2 = mock(Product.class);
    private final Category mockCat1 = mock(Category.class);
    private final Category mockCat2 = mock(Category.class);
    private RecordSeeker recordSeeker;
    private final Shop mockShop1 = mock(Shop.class);
    private final Shop mockShop2 = mock(Shop.class);

    @Before
    public void setup() {

        recordSeeker = new RecordSeeker("dataTest.xml");
    }

    @Test
    public void testSort() {

        recordSeeker.getProductList().add(mockProd1);
        recordSeeker.getProductList().add(mockProd2);
        when(mockProd2.getItemCategory()).thenReturn(mockCat1);
        when(mockProd1.getItemCategory()).thenReturn(mockCat2);
        when(mockProd2.getItemShop()).thenReturn(mockShop1);
        when(mockProd1.getItemShop()).thenReturn(mockShop2);
        when(mockProd2.getItemName()).thenReturn("Alpha");
        when(mockProd1.getItemName()).thenReturn("Beta");
        when(mockCat1.getItemName()).thenReturn("Alpha");
        when(mockCat2.getItemName()).thenReturn("Beta");
        when(mockShop1.getItemName()).thenReturn("Alpha");
        when(mockShop2.getItemName()).thenReturn("Beta");


        List productList = recordSeeker.getProductList();
        ByName sort1 = new ByName();
        Collections.sort(productList, sort1);
        Product product = (Product) productList.iterator().next();
        String first = product.getItemName();
        assertEquals("Name ", first, "Alpha");
        ByCategory sort2 = new ByCategory();
        Collections.sort(productList, sort2);
        product = (Product) productList.iterator().next();
        first = product.getItemCategory().getItemName();
        assertEquals("Name ", first, "Alpha");
        ByShop sort3 = new ByShop();
        Collections.sort(productList, sort3);
        product = (Product) productList.iterator().next();
        first = product.getItemShop().getItemName();
        assertEquals("Name ", first, "Alpha");


    }


}
