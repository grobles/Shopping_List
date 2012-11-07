package com;

import com.Persistance.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class:
 * Description:
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/10/12
 * Time: 12:03 PM *
 */
public class WriteandReadXMLFileTest {

    private final Item mockShop = mock(Shop.class);
    private final Item mockShop2 = mock(Shop.class);
    private Category category = new Category("CategoryName");
    private Shop shop = new Shop("ShopName");
    private Product product = new Product.Builder("ProductName", category, shop).build();
    private Category category2 = new Category("CategoryName2");
    private Shop shop2 = new Shop("ShopName2");
    private Product product2 = new Product.Builder("ProductName2", category2, shop2).build();

    private RecordSeeker recordSeeker;


    @Before
    public void setup() {
        recordSeeker = new RecordSeeker("dataTest.xml");


    }

    @Test

    public void testWriteXMLAndReadXML() {
        int size1 = recordSeeker.getShopList().size();
        recordSeeker.getShopList().add(mockShop);
        recordSeeker.getShopList().add(mockShop2);
        when(mockShop.getItemName()).thenReturn("Alpha");
        when(mockShop2.getItemName()).thenReturn("Beta");
        recordSeeker.writToXml();
        int size2 = recordSeeker.getShopList().size();
        assertEquals("size ", size1 + 2, size2);
    }

    @Test

    public void testShoppingList() {
        List<Product> productList1 = new ArrayList<Product>();
        productList1.add(product);
        productList1.add(product2);
        ShoppingList list1 = new ShoppingList("list1", productList1);
        List<Product> productList2 = new ArrayList<Product>();
        productList2.add(product);
        productList2.add(product2);
        ShoppingList list2 = new ShoppingList("list2", productList2);
        recordSeeker.getShoppingLists().add(list1);
        recordSeeker.getShoppingLists().add(list2);
        recordSeeker.writToXml();
        recordSeeker = new RecordSeeker("dataTest.xml");
        ShoppingList shoplisttest = (ShoppingList) recordSeeker.findItem("list1", recordSeeker.getShoppingLists());
        List<Product> productlisttest = shoplisttest.getProductsList();
        int size2 = productlisttest.size();
        assertEquals("size ", 2, size2);
        recordSeeker.writToXml();

    }


}