package com.GUI;

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 10/14/12
 * Time: 5:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValidateInput {

    /**
     * @param input String to be tested
     * @return bool true if only letters, false otherwise
     */
    public static boolean isText(String input) {
        if (input.matches("^[a-zA-Z ]+$")) {
            return true;
        }
        return false;
    }

    /**
     * @param digits String to be tested
     * @return bool true if only digits, false otherwise
     */
    public static boolean isDigit(String digits) {
        if (digits.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean isProduct(String digits) {
        if (digits.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }
}
