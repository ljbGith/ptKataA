package com.pillarescent.FromRoman;

public class RomanToArabicConversion {
    protected String _currentRomanValue;
    protected int _currentArabicValue;

    public RomanToArabicConversion(String romanStartingValue) {
        _currentRomanValue = romanStartingValue;
        _currentArabicValue = 0;
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
