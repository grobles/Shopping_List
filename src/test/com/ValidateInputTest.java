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

    private String validText, invalidText;
    private String validDigits, moreInvalidText;
    private String validDecimal, invalidDecimal;
    private String validEmail, invalidEmail;

    /**
     * setup the test conditions
     */
    @Before
    public void setup() {
        validText = "abcdefghijklmnopqrstuvwxyz's ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        invalidText = "12 Cookies";
        moreInvalidText = "peas & carrots";
        validDigits = "0123456789";
        validDecimal = "12.3";
        invalidDecimal = "12.3.2";
        validEmail = "someone@somewhere.com";
        invalidEmail = "bad email address";

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
     * Exercise the tests for decimals
     */
    @Test
    public void testIsDecimal() {
        Assert.assertTrue("Valid Decimal", ValidateInput.isDecimal(validDecimal));
        Assert.assertTrue("Valid Decimal", ValidateInput.isDecimal(validDigits));
        Assert.assertFalse("Invalid Decimal", ValidateInput.isDecimal(invalidDecimal));
    }

    /**
     * Exercise the tests for decimals
     */
    @Test
    public void testisEmail() {
        Assert.assertTrue("Valid Email", ValidateInput.isEmail(validEmail));
        Assert.assertFalse("Invalid Email", ValidateInput.isEmail(invalidEmail));
    }
}
