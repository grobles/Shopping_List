package com;

import com.GUI.ValidateInput;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 10/14/12
 * Time: 5:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValidateInputTest {

    private String validText, invalidText;
    private String validDigits, invalidDigits;

    /**
     * setup the test conditions
     */
    @Before
    public void setup() {
        validText = "Juice";
        invalidText = "12 Cookies";
        validDigits = "11";
        invalidDigits = "eighteen";
    }

    /**
     * Exercise the tests for text
     */
    @Test
    public void testText() {

        Assert.assertTrue("Valid Text", ValidateInput.isText(validText));
        Assert.assertFalse("Invalid Text", ValidateInput.isText(invalidText));
    }

    /**
     * Exercise the tests for digits
     */
    @Test
    public void testDigits() {
        Assert.assertTrue("Valid Digits", ValidateInput.isDigit(validDigits));
        Assert.assertFalse("Valid Digits", ValidateInput.isDigit(invalidDigits));

    }


}
