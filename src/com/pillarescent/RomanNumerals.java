package com.pillarescent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public String fromArabic(int num) {
        String romanChars;
        try {
            ArabicToRomanConversion conversion = new ArabicToRomanConversion(num);
            while ( ! conversion.conversionIsDone() ) {
                // ToDo: conversionState.isDone method to hide >0 check.
                conversion.shiftNextNumeralValueFromArabicToRoman();
                if (conversion.romanEndsWithMoreThan3InARow()) {
                    if (conversion.getCurrentRomanValue().endsWith("MMMM")) {
                        throw new Exception("Number " + num + " is too large for Roman numeral representation.");
                    }
                    conversion.replaceExcessiveRepeated1LikeNumeralsWith4Or9();
                }
            }
            romanChars = conversion.getCurrentRomanValue();
        }
        catch (Exception ex) {
            romanChars = "Error: " + ex.getMessage();
        }
        return romanChars;
    }

}
