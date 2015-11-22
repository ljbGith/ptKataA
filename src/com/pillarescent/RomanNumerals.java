package com.pillarescent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public String fromArabic(int num) {
        String romanChars = "";
        try {
            String biggestNumeral = biggestRequiredNumeral(num);
            int valOfBiggestNumeral = valueOfNumeral(biggestNumeral);
            while (num > 0) {
                romanChars = romanChars + "I";
                num--;
            }
        }
        catch (Exception ex) {
            // ToDo: What would Uncle Bob do
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
            throw new Exception("Number " + num + " is too small for Roman numeral representation.")
        }

        return result;
    }


    private static final Map<String, Integer> romanMap;

    static {
        Map<String,Integer> romanMap = new HashMap<String, Integer>();
        romanMap.put("M", 1000);
        romanMap.put("D",  500);
        romanMap.put("C",  100);
        romanMap.put("L",   50);
        romanMap.put("X",   10);
        romanMap.put("V",    5);
        romanMap.put("I",    1);
        romanMap = Collections.unmodifiableMap(aMap);
    }
    private int valueOfNumeral(String numeral) {

    }
}
