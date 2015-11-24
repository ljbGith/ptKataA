import org.junit.Test;

import java.io.StringWriter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RomanArabicIOTest {
    protected static final String newLine = System.lineSeparator();

    protected String outputFromRomanArabicConversionOn(String input) {
        StringWriter outputSink = new StringWriter();
        RomanArabicIO io = new RomanArabicIO(input, outputSink);
        io.handleInputs();
        return outputSink.toString().replaceAll("\\s+$", "");
    }

    protected void takeValueAsInputAndLookForOutputPrefix(String input, String expectedPrefix) {
        String actualOutput = outputFromRomanArabicConversionOn(input);
        assertTrue(actualOutput.startsWith(expectedPrefix));
    }
    protected void takeValueAsInputAndLookForSpecificOutput(String input, String expectedOutput) {
        String actualOutput = outputFromRomanArabicConversionOn(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void doInputGetAnyKindOfOutput() {
        StringWriter outputSink = new StringWriter();
        RomanArabicIO io = new RomanArabicIO("1", outputSink);
        io.handleInputs();
        String output = outputSink.toString();
        junit.framework.TestCase.assertFalse(output.length() == 0);
    }

    @Test
    public void takeIasInputAndOutput1() {
        takeValueAsInputAndLookForSpecificOutput("1", "I");
    }
    @Test
    public void takeMMMCMXCIXasInputAndOutput899() { takeValueAsInputAndLookForSpecificOutput("DCCCXCIX", "899"); }
}
