import com.pillarescent.FromRoman.RomanToArabicConversion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanToArabicConversionTest {
    String currRomanVal;
    int currArabicVal;

    protected void setValuesFrom(RomanToArabicConversion romanToArabicConv) {
        currRomanVal = romanToArabicConv.getCurrentRomanValue();
        currArabicVal = romanToArabicConv.getCurrentArabicValue();
    }

    @Test
    public void afterConstructingOnIQueryOnStateYieldsOrigArabicValAndArabicValue0() {
        RomanToArabicConversion romanToArabicConv = new RomanToArabicConversion("I");
        setValuesFrom(romanToArabicConv);
        assertEquals("I", currRomanVal);
        assertEquals(0, currArabicVal);
    }
    @Test
    public void afterConstructingOnIAndShiftingArabicIs1AndRomanIs_EMPTY_() throws Exception {
        RomanToArabicConversion romanToArabicConv = new RomanToArabicConversion("I");
        romanToArabicConv.shiftValueFromRomanToArabic();
        setValuesFrom(romanToArabicConv);
        assertEquals(1, currArabicVal);
        assertEquals("", currRomanVal);
    }
    // Test a Roman with 3 chunks of 2 numerals each (CDXCIV -> CD XC IV -> 494).
    @Test
    public void shiftRomanCDXCIV3TimesAndExpectArabic494() throws Exception {
        RomanToArabicConversion romanToArabicConv = new RomanToArabicConversion("CDXCIV"); // 494
        romanToArabicConv.shiftValueFromRomanToArabic();
        romanToArabicConv.shiftValueFromRomanToArabic();
        romanToArabicConv.shiftValueFromRomanToArabic();
        setValuesFrom(romanToArabicConv);
        assertEquals(494, currArabicVal);
        assertEquals("", currRomanVal);
    }
}
