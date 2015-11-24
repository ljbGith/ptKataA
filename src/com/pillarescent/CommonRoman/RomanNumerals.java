package com.pillarescent.CommonRoman;


import com.pillarescent.ToRoman.ArabicToRomanConversion;

public class RomanNumerals {
    public String fromArabic(int num) {
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

    public String toArabic(String romanNumeral) {
        return "";   // ToDo: IMPLEMENT THIS!
    }
    public boolean isWellFormedRomanNumeral(String romanToCheck) {
        return romanToCheck.matches("^(M{0,3}(D|C[DM])?C{0,3}(L|X[LC])?X{0,3}(V|I[VX])?I{0,3})$");
    }

}
