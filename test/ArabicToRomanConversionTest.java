import com.pillarescent.ArabicToRomanConversion;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ArabicToRomanConversionTest  {
    @Test
    public void afterConstructingOn1QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 1);
        assertEquals(currRomanVal, "");
    }
    @Test
    public void afterConstructingOnAnyVal_QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv;

        arabicToRomanConv = new ArabicToRomanConversion(2);
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 2);
        assertEquals(currRomanVal, "");

        arabicToRomanConv = new ArabicToRomanConversion(5);
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 5);
        assertEquals(currRomanVal, "");

        arabicToRomanConv = new ArabicToRomanConversion(157);
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 157);
        assertEquals(currRomanVal, "");
    }
    @Test
    public void afterConstructingOn1AndShiftingRomanIsIAndArabicIs0() throws Exception {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 0);
        assertEquals(currRomanVal, "I");
    }
    @Test
    public void afterConstructingOn157AndShiftingRomanIsCAndArabicIs57() throws Exception {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 57);
        assertEquals(currRomanVal, "C");
    }
    @Test
    public void afterConstructingOn157AndTwoShiftsRomanIsCLAndArabicIs7() throws Exception {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 7);
        assertEquals(currRomanVal, "CL");
    }
}
