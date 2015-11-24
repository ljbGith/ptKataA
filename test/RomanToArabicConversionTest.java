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
}
