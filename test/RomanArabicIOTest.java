
import java.io.StringWriter;

import com.pillarescent.FromRoman.RomanArabicIO;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class RomanArabicIOTest {
    protected static final String newLine = System.lineSeparator();

    protected static String outputFromRomanArabicConversionOn(String input) {
        StringWriter outputSink = new StringWriter();
        RomanArabicIO io = new RomanArabicIO(input, outputSink);
        io.handleInputs();
        return outputSink.toString().replaceAll("\\s+$", "");
    }
    void takeValueAsInputAndLookForOutputPrefix(String input, String expectedPrefix) {
        String actualOutput = outputFromRomanArabicConversionOn(input);
        assertTrue(actualOutput.startsWith(expectedPrefix));
    }
    protected void takeValueAsInputAndLookForSpecificOutput(String input, String expectedOutput) {
        String actualOutput = outputFromRomanArabicConversionOn(input);
        assertEquals(expectedOutput, actualOutput);
    }

    // CONSTRUCTION TEST
    @Test
    public void doInputGetAnyKindOfOutput() {
        StringWriter outputSink = new StringWriter();
        RomanArabicIO io = new RomanArabicIO("1", outputSink);
        io.handleInputs();
        String output = outputSink.toString();
        junit.framework.TestCase.assertFalse(output.length() == 0);
    }

    // LEXICAL-CHECK TESTS
    private boolean isGoodRoman(String toCheck) {
        StringWriter outputSink = new StringWriter();
        RomanArabicIO io = new RomanArabicIO(toCheck, outputSink);
        return io.isValidRoman();
    }

    @Test
    public void checkSmallRomanNumeralsForLexicalValidity() {
        assertTrue( isGoodRoman("I") && isGoodRoman("II") && isGoodRoman("III") && isGoodRoman("IV") && isGoodRoman("V"));
    }
    @Test
    public void checkSmallishRomanNumeralsForLexicalValidity() {
        assertTrue(isGoodRoman("VI") && isGoodRoman("IX") && isGoodRoman("XIV") && isGoodRoman("XXIX"));
    }
    @Test
    public void checkMediumRomanNumeralsForLexicalValidity() {
        assertTrue(isGoodRoman("XLIV") && isGoodRoman("LXXXVIII") && isGoodRoman("XC"));
        assertTrue(isGoodRoman("CCXXII") && isGoodRoman("CD") && isGoodRoman("CDX"));
    }
    @Test
    public void checkBigRomanNumeralsForLexicalValidity() {
        assertTrue( isGoodRoman("DXCIX") && isGoodRoman("DCCC") && isGoodRoman("CM") );
        assertTrue( isGoodRoman("MMMCMXCIX") );
    }
    @Test
    public void checkBadRomanNumeralsDDGetLexicallyRejected() { assertFalse( isGoodRoman("DD") ); }
    @Test
    public void checkBadRomanNumeralsIIIIGetLexicallyRejected() { assertFalse( isGoodRoman("IIII") ); }
    @Test
    public void checkBadRomanNumeralsIXVGetLexicallyRejected() { assertFalse( isGoodRoman("IXV") ); }
    @Test
    public void checkBadRomanNumeralsZZZGetLexicallyRejected() { assertFalse( isGoodRoman("ZZZ") ); }
    @Test
    public void inputYYYAsRomanGetErrorMessage() {
        takeValueAsInputAndLookForOutputPrefix("YYY", "Error: expected a Roman numeral");
    }

    // "NORMAL" VALUE CONVERSION TESTS.
    @Test
    public void takeIasInputAndOutput1() {
        takeValueAsInputAndLookForSpecificOutput("I", "1");
    }
    @Test
    public void takeMMMCMXCIXasInputAndOutput899() { takeValueAsInputAndLookForSpecificOutput("DCCCXCIX", "899"); }

    // "OTHER" VALUE CONVERSION TESTS.
    @Test
    public void takeXXXXasInputAndGetError() {
        takeValueAsInputAndLookForOutputPrefix("XXXX", "Error: expected a Roman numeral ");
    }
    @Test
    public void take_NOTHING_asInputAndGet_NOTHING_asOutput() {
        takeValueAsInputAndLookForSpecificOutput("", "");
    }
    @Test
    public void takeMMMMasInputAndGetError() {
        takeValueAsInputAndLookForOutputPrefix("MMMM", "Error: expected a Roman numeral like");
    }

}
