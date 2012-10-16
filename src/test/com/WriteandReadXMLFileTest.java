package com;

import com.Persistance.DataContainers;
import com.Persistance.ReadXMLFile;
import com.Persistance.RecordSeeker;
import com.Persistance.WriteXMLFile;
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
    DataContainers someDc = DataContainers.getInstance();
    private WriteXMLFile wxml;
    private ReadXMLFile rxml;
    private RecordSeeker recordSeekerProduct;


    @Before
    public void setup() {
        DataContainers someDc = DataContainers.getInstance();
        someDc.getShopList().add(mockShop);
        someDc.getShopList().add(mockShop2);
        wxml = new WriteXMLFile("dataTest.xml", someDc);
        rxml = new ReadXMLFile("dataTest.xml");


    }

    @Test

    public void testWriteXMLAndReadXML() {

        when(mockShop.getItemName()).thenReturn("Alpha");
        when(mockShop2.getItemName()).thenReturn("Beta");
        wxml.writeFile();
        someDc = rxml.readDC();
        int arraySize = someDc.getShopList().size();
        assertEquals("size ", 2, arraySize);
    }


}