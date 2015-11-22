package com.pillarescent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public String fromArabic(int num) {
        String romanChars = "";
        try {
            while (num > 0) {
                String biggestNumeral = biggestRequiredNumeral(num);
                int valOfBiggestNumeral = valueOfNumeral(biggestNumeral);
                romanChars = romanChars + biggestNumeral;
                num -= valOfBiggestNumeral;
            }
        }
        catch (Exception ex) {
            // ToDo: What would Uncle Bob do?
            // At least make sure result is "".
            romanChars = "";
        }
        return romanChars;
    }

    private String biggestRequiredNumeral(int num)
        throws Exception {
        String result = "";

        if (num >= 5000) {
            throw new Exception("Number " + num + " is too large for Roman numeral representation.");
        } else if (num >= 1000) {
            result = "M";
        } else if (num >= 500) {
            result = "D";
        } else if (num >= 100) {
            result = "C";
        } else if (num >= 50) {
            result = "L";
        } else if (num >= 10) {
            result = "X";
        } else if (num >= 5) {
            result = "V";
        } else if (num >= 1) {
            result = "I";
        } else {
            throw new Exception("Number " + num + " is too small for Roman numeral representation.");
        }

        return result;
    }


    private static int valueOfNumeral(String numeral)
        throws Exception {
        if (numeral.equals("M")) { return 1000; }
        if (numeral.equals("D")) { return  500; }
        if (numeral.equals("C")) { return  100; }
        if (numeral.equals("L")) { return   50; }
        if (numeral.equals("X")) { return   10; }
        if (numeral.equals("V")) { return    5; }
        if (numeral.equals("I")) { return    1; }
        throw new Exception("String '" + numeral + "' is not a Roman numeral.");
    }
}
