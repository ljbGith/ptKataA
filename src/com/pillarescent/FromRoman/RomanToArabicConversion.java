package com.pillarescent.FromRoman;

import com.pillarescent.CommonRoman.RomanNumerals;


public class RomanToArabicConversion {
    protected String _currentRomanValue;
    protected int _currentArabicValue;
    protected boolean _conversionFailed;

    public RomanToArabicConversion(String romanStartingValue) {
        _currentRomanValue = romanStartingValue;
        _currentArabicValue = 0;
        _conversionFailed = false;
        flagConversionFailureOnBadRomanNumeralString();
    }

    public int getCurrentArabicValue() {
                                     return _currentArabicValue;
                                                                }

    protected void setCurrentArabicValue(int newValue) {
                                                     _currentArabicValue = newValue;
                                                                                    }

    public String getCurrentRomanValue() { return _currentRomanValue; }

    protected void setCurrentRomanValue(String newValue) { _currentRomanValue = newValue; }

    public boolean getConversionFailed() { return _conversionFailed; }

    protected void setConversionFailed(boolean newValue) { _conversionFailed = newValue; }

    public void flagConversionFailureOnBadRomanNumeralString() {
        if ( ! RomanNumerals.isWellFormedRomanNumeral(_currentRomanValue) ) {
            setConversionFailed(true);
        }
    }

    public void shiftValueFromRomanToArabic() {
        String highestValuedRomanPrefix = biggestRomanValueUnit(getCurrentRomanValue());
        if ( highestValuedRomanPrefix.isEmpty() ) {
            // Here, highest prefix cannot be "" due to normal shifting, so it is the result of an error.
            setConversionFailed(true);
        }
        else {
            removeRomanPrefixAndAddValueToArabicSum(highestValuedRomanPrefix);
        }
    }

    protected void removeRomanPrefixAndAddValueToArabicSum(String highestValuedRomanPrefix) {
        int valueOfRomanPrefix = integerValue(highestValuedRomanPrefix);
        String newRomanValue = getCurrentRomanValue().replaceFirst("^" + highestValuedRomanPrefix, "");
        setCurrentRomanValue(newRomanValue);
        int newArabicValue = getCurrentArabicValue() + valueOfRomanPrefix;
        setCurrentArabicValue(newArabicValue);
    }

    public boolean conversionIsDone() {
        // Quit "converting" if anything goes wrong or all the Roman has been converted and removed.
        return ( getConversionFailed() || getCurrentRomanValue().equals("") );
    }
    /*
        A "Roman value unit" is either a "subtraction pair" of Roman numerals
        (CM = 900, CD = 400, XC = 90, etc.) or a single Roman numeral (M = 1000, etc.).
        Pairs take precedence, so as we decode a Roman numeral string, walking through
        the characters looking for what value to add to the accumulating total, when
        we see a "C" at the beginning, it only means "add 100" to the accumulating value
        IF there is no "M" following it. If we see a "CM", both those characters are
        processed together and yield the value 900. (Likewise for CD, XC, etc.)
     */

    private static String biggestRomanValueUnit(String roman) {
        final String[] possibleUnits = {
                "CM", "CD", "M", "D", "XC", "XL", "C", "L", "IX", "IV", "X", "V", "I"
        };
        // Checking these in order, one MUST match the start of 'roman' and
        // the first one to match MUST be the highest-valued Roman value unit.

        String result = ""; // Assume failure, set it later if result is obtained.
        boolean found = false;
        int possibleUnitIndex = 0;
        String possibleUnit = "";
        while ( ( ! found ) && (possibleUnitIndex < possibleUnits.length) ) {
            possibleUnit = possibleUnits[possibleUnitIndex];
            found = roman.startsWith(possibleUnit);
            possibleUnitIndex++;
        }
        // Not found should only happen if roman was empty.
        if ( found ) {
            result = possibleUnit;
        }
        return result;
    }

    private static int integerValue(String roman) {
        if (roman.equals("M"))  { return 1000; }
        if (roman.equals("CM")) { return  900; }
        if (roman.equals("D"))  { return  500; }
        if (roman.equals("CD")) { return  400; }
        if (roman.equals("C"))  { return  100; }
        if (roman.equals("XC")) { return   90; }
        if (roman.equals("L"))  { return   50; }
        if (roman.equals("XL")) { return   40; }
        if (roman.equals("X"))  { return   10; }
        if (roman.equals("IX")) { return    9; }
        if (roman.equals("V"))  { return    5; }
        if (roman.equals("IV")) { return    4; }
        if (roman.equals("I"))  { return    1; }
        return 0;
    }
}
