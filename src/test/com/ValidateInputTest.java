package com;

import com.GUI.ValidateInput;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: ValidateInputTest
 * Description: Tests for teh ValidateInput class
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/14/12
 */
public class ValidateInputTest {

    private String validText, invalidText, moreValidText;
    private String validDigits, invalidDigits, moreInvalidText;
    private String validDecimal, invalidDecimal;

    /**
     * setup the test conditions
     */
    @Before
    public void setup() {
        validText = "abcdefghijklmnopqrstuvwxyz's ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        invalidText = "12 Cookies";
        moreInvalidText = "peas & carrots";
        validDigits = "0123456789";
        invalidDigits = "eighteen";
        validDecimal = "12.3";
        invalidDecimal = "12.3.2";
    }

    /**
     * Exercise the tests for text
     */
    @Test
    public void testIsText() {

        Assert.assertTrue("Valid Text", ValidateInput.isText(validText));
        Assert.assertFalse("Invalid Text", ValidateInput.isText(invalidText));
        Assert.assertFalse("Invalid Text with special char", ValidateInput.isText(moreInvalidText));
    }

    /**
     * Exercise the tests for digits
     */
    @Test
    public void testIsDigits() {
        Assert.assertTrue("Valid Digits", ValidateInput.isDigit(validDigits));
        Assert.assertFalse("Invalid Digits", ValidateInput.isDigit(invalidDigits));
    }

    /**
     * Exercise the tests for decimals
     */
    @Test
    public void testIsDecimal() {
        Assert.assertTrue("Valid Decimal", ValidateInput.isDecimal(validDecimal));
        Assert.assertTrue("Valid Decimal", ValidateInput.isDecimal(validDigits));
        Assert.assertFalse("Invalid Decimal", ValidateInput.isDecimal(invalidDecimal));
    }


}
