package com.pillarescent;


public class RomanNumerals {
    public String  fromArabic(int num) {
        String romanChars = "";
        while (num > 0) {
            romanChars = romanChars + "I";
            num--;
        }
        return romanChars;
    }
}
