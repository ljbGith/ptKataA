import com.pillarescent.ArabicToRomanConversion;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import junit.framework.Assert;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

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
        assertEquals(1, currArabicVal);
        assertEquals("", currRomanVal);
    }
    @Test
    public void afterConstructingOnAnyVal_QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        ArabicToRomanConversion arabicToRomanConv;

        arabicToRomanConv = new ArabicToRomanConversion(2);
        setValuesFrom(arabicToRomanConv);
        assertEquals(2, currArabicVal);
        assertEquals("", currRomanVal);

        arabicToRomanConv = new ArabicToRomanConversion(5);
        setValuesFrom(arabicToRomanConv);
        assertEquals(5, currArabicVal);
        assertEquals("", currRomanVal);

        arabicToRomanConv = new ArabicToRomanConversion(157);
        setValuesFrom(arabicToRomanConv);
        assertEquals(157, currArabicVal);
        assertEquals("", currRomanVal);
    }
    @Test
    public void afterConstructingOn1AndShiftingRomanIsIAndArabicIs0() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(0, currArabicVal);
        assertEquals("I", currRomanVal);
    }
    @Test
    public void afterConstructingOn157AndShiftingRomanIsCAndArabicIs57() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(57, currArabicVal);
        assertEquals("C", currRomanVal);
    }
    @Test
    public void afterConstructingOn157AndTwoShiftsRomanIsCLAndArabicIs7() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(7, currArabicVal);
        assertEquals("CL", currRomanVal);
    }
    @Test
    public void afterConstructingOn157AndFiveShiftsRomanIsCLVIIAndArabicIs0() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(157);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(7, currArabicVal);
        assertEquals("CL", currRomanVal);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(1, currArabicVal);
        assertEquals("CLVI", currRomanVal);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        setValuesFrom(arabicToRomanConv);
        assertEquals(0, currArabicVal);
        assertEquals("CLVII", currRomanVal);
    }
    @Test
    public void after4ShiftsRomanFor4DoesNotEndWithMoreThan3InARow() throws Exception {
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(4);
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.shiftNextNumeralValueFromArabicToRoman();
        arabicToRomanConv.replaceExcessiveRepeated1LikeNumeralsWith4Or9();
        assertFalse(arabicToRomanConv.romanEndsWithMoreThan3InARow());
    }

}
