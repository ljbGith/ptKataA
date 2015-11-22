import org.junit.Test;

public class ArabicToRomanConversionTest  {
    @Test
    public void afterConstructing_QueryOnStateYieldsOrigArabicValAndEmptyRomanRepresentation() {
        int currArabicVal;
        String currRomanVal;
        ArabicToRomanConversion arabicToRomanConv = new ArabicToRomanConversion(1);
        currArabicVal = arabicToRomanConv.getCurrentArabicValue();
        currRomanVal = arabicToRomanConv.getCurrentRomanValue();
        assertEquals(currArabicVal, 1);
        assertEquals(currRomanVal, "");
    }
}
