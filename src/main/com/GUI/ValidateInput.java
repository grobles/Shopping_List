package com.GUI;

/**
 * Class: ValidateInput
 * Description: Used to validate user input prior to adding teh data to the lists
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/14/12
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {

    //valid e-mail
    public static final Pattern VALID_EMAIL_ADDRESS =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    //valid alpha characters, white space and apostrophes
    public static final Pattern VALID_TEXT = Pattern.compile("^[a-zA-Z '\"]+$");

    //valid specific decimal pattern - any digit, 0 or 1 decimal points, at least one digit following the decimal
    public static final Pattern VALID_DECIMAL = Pattern.compile("\\d+([.{0,1}]\\d+)?");

    /**
     * @param input String to be tested
     * @return bool true if only letters, false otherwise
     */
    public static boolean isText(String input) {
        Matcher matcher = VALID_TEXT.matcher(input);
        return matcher.find();
    }

    /**
     * @param digits String to be tested
     * @return bool true if only digits, false otherwise
     */
    public static boolean isDigit(String digits) {
        //matches        any digit 0-9
        if (digits.matches("\\d+?") || digits.equals("")) {
            return true;
        }
        return false;
    }

    //todo use common libraries don't roll your own solutions
    // see: http://commons.apache.org/lang/api-3.1/org/apache/commons/lang3/StringUtils.html

    /**
     * @param digits String to be tested
     * @return bool true if decimal pattern is found, false otherwise
     */
    public static boolean isDecimal(String digits) {
        Matcher matcher = VALID_DECIMAL.matcher(digits);
        return matcher.find();
    }

    /**
     * @param emailStr String to be tested
     * @return bool true if email address is valid, false otherwise
     */
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS.matcher(emailStr);
        return matcher.find();
    }
}
