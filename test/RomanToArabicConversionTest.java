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
        romanToArabicConv.shiftValueFromArabicToRoman();
        setValuesFrom(romanToArabicConv);
        assertEquals(1, currArabicVal);
        assertEquals("", currRomanVal);
    }
}
