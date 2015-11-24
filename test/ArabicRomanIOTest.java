import com.pillarescent.ArabicRomanIO;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.StringWriter;


public class ArabicRomanIOTest {

    protected String outputFromArabicRomanConversionOn(String input) {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO(input, outputSink);
        io.handleInputs();
        return outputSink.toString().replaceAll("\\s+$", "");
    }

    protected void takeValueAsInputAndLookForOutputPrefix(String input, String expectedPrefix) {
        String actualOutput = outputFromArabicRomanConversionOn(input);
        assertTrue(actualOutput.startsWith(expectedPrefix));
    }
    protected void takeValueAsInputAndLookForSpecificOutput(String input, String expectedOutput) {
        String actualOutput = outputFromArabicRomanConversionOn(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void doInputGetAnyKindOfOutput() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("1", outputSink);
        io.handleInputs();
        String output = outputSink.toString();
        junit.framework.TestCase.assertFalse(output.length() == 0);
    }

    @Test
    public void take1asInputAndOutputI() {
         takeValueAsInputAndLookForSpecificOutput("1", "I");
    }
    @Test
    public void take3999asInputAndOutputMMMCMXCIX() {
        takeValueAsInputAndLookForSpecificOutput("3999", "MMMCMXCIX");
    }
    @Test
    public void takeNoInputAndOutput_NOTHING_() {
        takeValueAsInputAndLookForSpecificOutput("", "");
    }
    @Test
    public void takeNonNumericInputAndOutput_ErrorMessage_() {
        takeValueAsInputAndLookForOutputPrefix("zzz", "Error: expected a regular number ");
    }
    @Test
    public void takeInputThatIsTooBigAndOutput_ErrorMessage_() {
        String bigNumString = "4000";
        takeValueAsInputAndLookForOutputPrefix(bigNumString, "Error: Number " + bigNumString + " is too large ");
    }
    @Test
    public void takeInputThatIsTooSmallAndOutput_ErrorMessage_() {
        String smallNumString = "-1";
        takeValueAsInputAndLookForOutputPrefix(smallNumString, "Error: Number " + smallNumString + " is too small ");
    }
    @Test
    public void take1And2And3OnSeparateLinesAndOutputI_II_and_IIIOnSeparateLines() {
        String  input = String.join(System.lineSeparator(), new String[] {"1", "2", "3"});
        String output = String.join(System.lineSeparator(), new String[] {"I", "II", "III"});
        takeValueAsInputAndLookForSpecificOutput(input, output);
    }
    @Test
    public void takeQuitOnFirstLineAndOutput_NOTHING_() {
        takeValueAsInputAndLookForSpecificOutput("quit", "");
    }
}
