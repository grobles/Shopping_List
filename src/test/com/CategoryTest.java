package com;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 9/22/12
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryTest {
    //private data members
    private String categoryName, shopName;
    private Category aCategory = new Category();
    private Shop aShop = new Shop();

    /**
     * set up test case
     */
    @Before
    public void setup() {
        //set the category and shop
        categoryName = "Category 1";
        shopName = "Some Shop Name";
        aCategory.setCategory(categoryName, shopName);
    }

    /**
     * exercise the Category methods.
     */
    @Test
    public void testCategory() {
        assertEquals("Category Name", categoryName, aCategory.getCategory());
        assertEquals("Shop Name", shopName, aCategory.getShop());
    }
}
