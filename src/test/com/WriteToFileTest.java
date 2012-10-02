package com;

import com.Utilities.WriteToFile;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Class: DataContainersTest
 * Description: Helps test the DataContainers class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 20/09/12
 * Time: 10:12 PM *
 */
/*
    */

public class WriteToFileTest implements Serializable {
    //private data members
    private final Item mockProduct = mock(Product.class);
    private final Item mockProduct2 = mock(Product.class);
    private final Item mockCategory = mock(Category.class);
    private final Item mockCategory2 = mock(Category.class);
    private final Item mockShop = mock(Shop.class);
    private final Item mockShop2 = mock(Shop.class);
    DataContainers someDc = DataContainers.getInstance();


    /**
     * setup the Product to test
     */
    @Before
    public void setup() {
        someDc.getProductList().add(mockProduct);
        someDc.getProductList().add(mockProduct2);
        someDc.getCategoryList().add(mockCategory);
        someDc.getCategoryList().add(mockCategory2);
        someDc.getShopList().add(mockShop);
        someDc.getShopList().add(mockShop2);


    }


    /**
     * exercise the DataContainers methods
     */
    @Test

    public void testWriteAndRead() {

        DataContainers someDc = DataContainers.getInstance();
        WriteToFile.writeSerializeFileTest(someDc);
        someDc = WriteToFile.readSerializeFileTest();

        int arraySize = someDc.getProductList().size();
        assertEquals("size ", arraySize, 2);
    }


}
