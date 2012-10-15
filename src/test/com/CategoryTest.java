package com;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Class: CategoryTest
 * Description: Helps test the Category class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 9/22/12
 * Time: 12:52 PM *
 */
public class CategoryTest {
    //private data members
    private String categoryName, shopName;
    private Category aCategory;


    /**
     * set up test case
     */
    @Before
    public void setup() {
        //set the category and shop
        categoryName = "Category 1";
        shopName = "Some Shop Name";
        aCategory = new Category(categoryName);
    }

    /**
     * exercise the Category methods.
     */
    @Test
    public void testCategory() {
        assertEquals("Category Name", categoryName, aCategory.getItemName());

    }

    /**
     * test setItemName.
     */
    @Test
    public void testSetItemName() {
        aCategory.setItemName("Category2");
        assertEquals("Category Name", "Category2", aCategory.getItemName());

    }
}
