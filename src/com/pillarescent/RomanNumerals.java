package com.pillarescent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public String fromArabic(int num) {
        String romanChars = "";
        try {
            ArabicToRomanConversion conversion = new ArabicToRomanConversion(num);
            while ( ! conversion.conversionIsDone() ) {
                // ToDo: conversionState.isDone method to hide >0 check.
                conversion.shiftNextNumeralValueFromArabicToRoman();
            }
        }
        catch (Exception ex) {
            // ToDo: What would Uncle Bob do?
            // At least make sure result is "".
            romanChars = "";
        }
        return romanChars;
    }

}
