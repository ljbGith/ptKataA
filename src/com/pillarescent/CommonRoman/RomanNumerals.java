package com.pillarescent.CommonRoman;


import com.pillarescent.FromRoman.RomanToArabicConversion;
import com.pillarescent.ToRoman.ArabicToRomanConversion;

public class RomanNumerals {

    // Private constructor flags attempts (by code using this class's static methods) to construct an instance.
    private RomanNumerals() { }

    public static String fromArabic(int num) {
        String romanChars;
        try {
            ArabicToRomanConversion conversion = new ArabicToRomanConversion(num);
            while ( ! conversion.conversionIsDone() ) {
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

    public static int toArabic(String romanNumeral) {
        int arabicValue = -1;  // Assume failure.
        try {
            RomanToArabicConversion conversion = new RomanToArabicConversion(romanNumeral);
            // If romanNumeral is bad Roman (ex.: "MMMM" or "Z"), conversion is both done and failed.
            while ( ! conversion.conversionIsDone() ) {
                conversion.shiftValueFromRomanToArabic();
            }
            if ( ! conversion.getConversionFailed() ) {
                arabicValue = conversion.getCurrentArabicValue();
            }
        } catch (Exception conversionException) {
            // ToDo: Analyze calls inside the try: Is there any reason to believe this will happen?
            arabicValue = -1;
        }
        return arabicValue;
    }

    public static boolean isWellFormedRomanNumeral(String romanToCheck) {
        return romanToCheck.matches("^(M{0,3}(D|C[DM])?C{0,3}(L|X[LC])?X{0,3}(V|I[VX])?I{0,3})$");
    }

}
