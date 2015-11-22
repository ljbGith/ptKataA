package com.pillarescent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public String fromArabic(int num) {
        String romanChars = "";
        try {
            ArabicToRomanConversionState conversionState = new ArabicToRomanConversionState(num);
            while (conversionState.getCurrentArabicValue() > 0) {
                // ToDo: conversionState.isDone method to hide >0 check.
                conversionState.shiftNextNumeralValueFromArabicToRoman();
            }
        }
        catch (Exception ex) {
            // ToDo: What would Uncle Bob do?
            // At least make sure result is "".
            romanChars = "";
        }
        return romanChars;
    }

    private static String biggestRequiredNumeral(int num)
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


    protected class ArabicToRomanConversionState {
        protected int _currentArabicValue;
        protected String _currentRomanValue;
        public ArabicToRomanConversionState(int arabicStartingValue) {
            _currentArabicValue = arabicStartingValue;
            _currentRomanValue = "";   // Redundant?
        }
        public int getCurrentArabicValue() {
            return _currentArabicValue;
        }
        protected void setCurrentArabicValue(int newValue) {
            _currentArabicValue = newValue;
        }
        public String getCurrentRomanValue() {
            return _currentRomanValue;
        }
        protected void setCurrentRomanValue(String newValue) {
            _currentRomanValue = newValue;
        }
        public void shiftNextNumeralValueFromArabicToRoman() throws Exception {
            String biggestNumeral = biggestRequiredNumeral(getCurrentArabicValue());
            int valOfBiggestNumeral = valueOfNumeral(biggestNumeral);
            setCurrentRomanValue(getCurrentRomanValue() + biggestNumeral);
            setCurrentArabicValue(getCurrentArabicValue() - valOfBiggestNumeral);
        }
    }
}
