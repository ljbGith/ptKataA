package com.pillarescent;

public class RomanToArabicConversion {
    protected String _currentRomanValue;
    protected int _currentArabicValue;

    public RomanToArabicConversion(int arabicStartingValue) {
        _currentRomanValue = "";   // Redundant?
        _currentArabicValue = arabicStartingValue;
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

    protected void setCurrentRomanValue(String newValue) { _currentRomanValue = newValue; }


}
