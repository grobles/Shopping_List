package com.GUI;

/**
 * Class: ValidateInput
 * Description: Used to validate user input prior to adding teh data to the lists
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/14/12
 */
public class ValidateInput {

    /**
     * @param input String to be tested
     * @return bool true if only letters, false otherwise
     */
    public static boolean isText(String input) {
        // matches       any upper or lowercase letters only
        if (input.matches("^[a-zA-Z ']+$")) {
            return true;
        }
        return false;
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

    public static boolean isDecimal(String digits) {
        //matches         any digit, 0 or 1 decimal points, at least one digit following the decimal
        if (digits.matches("\\d+([.{0,1}]\\d+)?")) {
            return true;
        }
        return false;
    }
}
