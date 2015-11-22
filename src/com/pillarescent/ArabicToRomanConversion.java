package com.pillarescent;

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

    public void replaceExcessiveRepeated1LikeNumeralsWith4Or9() throws Exception {
        String romanValue = getCurrentRomanValue();
        if (romanValue.length() == 0) {
            return;
        }
        // If it ends with IIII, I must be the repeated numeral; XXXX then it's X; etc.
        String repeatedNumeral = romanValue.substring(romanValue.length() - 1);
        String strippedRomanValue = romanValueWithRepeatedFinalNumeralRemoved();
        if (strippedRomanValue.length() > 0) {
            String possibleFinal5LikeNumeral = strippedRomanValue.substring(strippedRomanValue.length() - 1);
            if (isFiveLike(possibleFinal5LikeNumeral)) {
                // Replace VIIII with IX, LXXXX with XC, and DCCCC with CM.
                int valOfRepeatedNumeral = valueOfNumeral(repeatedNumeral);
                String nextHigher1LikeNumeral = biggestRequiredNumeral(valOfRepeatedNumeral * 10);
                String furtherStrippedRomanValue = strippedRomanValue.substring(0, strippedRomanValue.length() - 1);
                setCurrentRomanValue(furtherStrippedRomanValue + repeatedNumeral + nextHigher1LikeNumeral);
            }
            else {
                // Replace IIII with IV, XXXX with XL, and CCCC with CD.
                int valOfRepeatedNumeral = valueOfNumeral(repeatedNumeral);
                String nextHigher5LikeNumeral = biggestRequiredNumeral(valOfRepeatedNumeral * 5);
                setCurrentRomanValue(strippedRomanValue + repeatedNumeral + nextHigher5LikeNumeral);
            }
        }
    }

    public boolean conversionIsDone() {
        return (getCurrentArabicValue() == 0);
    }

    private String romanValueWithRepeatedFinalNumeralRemoved() {
        String romanValue = getCurrentRomanValue();
        if (romanValue.length() == 0) {
            return romanValue;
        }
        String finalNumeral = romanValue.substring(romanValue.length()-1);
        while (romanValue.endsWith(finalNumeral)) {
            romanValue = romanValue.substring(0, romanValue.length() - 1);
        }
        return romanValue;
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

    public static boolean isOneLike(String numeral) {
        boolean result = false;
        return ((numeral.length() == 1) && "IXCM".contains(numeral));
    }
    public static boolean isFiveLike(String numeral) {
        boolean result = false;
        return ((numeral.length() == 1) && "VLD".contains(numeral));
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

