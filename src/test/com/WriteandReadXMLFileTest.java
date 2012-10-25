package com;

import com.Persistance.RecordSeeker;
import org.junit.Before;
import org.junit.Test;

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


}