package com;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 9/22/12
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShopTest {
    //private data members
    private String testShop;
    private Shop myShop;

    /**
     * setup the test case.
     */
    @Before
    public void setup() {
        //set the shop name
        testShop = "Some Shop Name";
        myShop = new Shop(testShop);
    }

    /**
     * exercise the Shop methods.
     */
    @Test
    public void testShop() {
        assertEquals("Shop name test", testShop, myShop.getItemName());

    }
}
