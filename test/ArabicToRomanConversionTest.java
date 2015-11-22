import com.pillarescent.ArabicToRomanConversion;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ArabicToRomanConversionTest  {
    int currArabicVal;
    String currRomanVal;

    protected void setValuesFrom(ArabicToRomanConversion arabicToRomanConv) {
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
    }

    @Test
    public void afterConstructingOn1QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 1);
        assertEquals(currRomanVal, "");
    }
    @Test
    public void afterConstructingOnAnyVal_QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        ArabicToRomanConversion arabicToRomanConv;

        arabicToRomanConv = new ArabicToRomanConversion(2);
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 2);
        assertEquals(currRomanVal, "");

        arabicToRomanConv = new ArabicToRomanConversion(5);
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 5);
        assertEquals(currRomanVal, "");

        arabicToRomanConv = new ArabicToRomanConversion(157);
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 157);
        assertEquals(currRomanVal, "");
    }
    @Test
    public void afterConstructingOn1AndShiftingRomanIsIAndArabicIs0() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 0);
        assertEquals(currRomanVal, "I");
    }
    @Test
    public void afterConstructingOn157AndShiftingRomanIsCAndArabicIs57() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 57);
        assertEquals(currRomanVal, "C");
    }
    @Test
    public void afterConstructingOn157AndTwoShiftsRomanIsCLAndArabicIs7() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 7);
        assertEquals(currRomanVal, "CL");
    }
    @Test
    public void afterConstructingOn157AndFiveShiftsRomanIsCLVIIAndArabicIs0() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 7);
        assertEquals(currRomanVal, "CL");
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 1);
        assertEquals(currRomanVal, "CLVI");
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(currArabicVal, 0);
        assertEquals(currRomanVal, "CLVII");
    }
}
