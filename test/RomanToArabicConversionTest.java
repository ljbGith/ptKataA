import com.pillarescent.RomanToArabicConversion;
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
    public void afterConstructingOn1QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        RomanToArabicConversion romanToArabicConv = new RomanToArabicConversion();
        setValuesFrom(romanToArabicConv);
        assertEquals(1, currArabicVal);
        assertEquals("", currRomanVal);
    }
}
