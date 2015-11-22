package com.pillarescent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicToRomanConversion {
    protected int _currentArabicValue;
    protected String _currentRomanValue;
    public ArabicToRomanConversion(int arabicStartingValue) {
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

    public boolean romanEndsWithMoreThan3InARow() {
        String romanValue = getCurrentRomanValue();
        return romanValue.matches(".*(I{4}|X{4}|C{4}|M{4})$");
            // Regex says match on 4 of any of the following at the end ($)
            // of the string: 'I' or 'X' or 'C' or 'M'.
    }

    private class Replacement {
        public String oldStr;
        public String newStr;
        public Replacement(String _oldStr, String _newStr) {
            oldStr = _oldStr;
            newStr = _newStr;
        }
    }


    public void replaceExcessiveRepeated1LikeNumeralsWith4Or9() throws Exception {
        Replacement[] replacements = new Replacement[] {
                new Replacement("VIIII", "IX"),
                new Replacement( "IIII", "IV"),
                new Replacement("LXXXX", "XC"),
                new Replacement( "XXXX", "XL"),
                new Replacement("DCCCC", "CM"),
                new Replacement( "CCCC", "CD")
        };
        String romanValue = getCurrentRomanValue();
        String newRoman = "";
        boolean matchedAndDone = false;
        for (int replacementIdx = 0;
             ( ! matchedAndDone ) && (replacementIdx < replacements.length);
             replacementIdx++) {
            String stringToMatch = replacements[replacementIdx].oldStr;
            String replacementStr = replacements[replacementIdx].newStr;
            Pattern pat = Pattern.compile(stringToMatch + "$"); // +"$" => match only at end
            Matcher matcher = pat.matcher(romanValue);
            newRoman = matcher.replaceAll(replacementStr);
            matchedAndDone = ( ! newRoman.equals(romanValue) );
        }
        if (matchedAndDone) {
            setCurrentRomanValue(newRoman);
        }
    }

    public boolean conversionIsDone() {
        return (getCurrentArabicValue() == 0);
    }


    private static String biggestRequiredNumeral(int num) throws Exception {
        String result;

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

    private static int valueOfNumeral(String numeral) throws Exception {
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

