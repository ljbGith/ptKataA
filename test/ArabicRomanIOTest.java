import com.pillarescent.ArabicRomanIO;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.StringWriter;


public class ArabicRomanIOTest {

    protected void takeValAsInputAndLookForOutputPrefix(String input, String expectedPrefix) {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO(input, outputSink);
        io.handleInputs();
        String actualOutput = outputSink.toString().replaceAll("\\s+$", "");
        assertTrue(actualOutput.startsWith(expectedPrefix));
    }
    protected void takeValAsInputAndLookForSpecificOutput(String input, String expectedOutput) {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO(input, outputSink);
        io.handleInputs();
        String actualOutput = outputSink.toString().replaceAll("\\s+$", "");
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
         takeValAsInputAndLookForSpecificOutput("1", "I");
    }
    @Test
    public void take3999asInputAndOutputMMMCMXCIX() {
        takeValAsInputAndLookForSpecificOutput("3999", "MMMCMXCIX");
    }
    @Test
    public void takeNoInputAndOutput_NOTHING_() {
        takeValAsInputAndLookForSpecificOutput("", "");
    }
    @Test
    public void takeNonNumericInputAndOutput_ErrorMessage_() {
        takeValAsInputAndLookForOutputPrefix("zzz", "Error: expected a regular number ");
    }
    @Test
    public void takeInputThatIsTooBigAndOutput_ErrorMessage_() {
        String bigNumString = "4000";
        takeValAsInputAndLookForOutputPrefix(bigNumString, "Error: Number " + bigNumString + " is too large ");
    }
    @Test
    public void takeInputThatIsTooSmallAndOutput_ErrorMessage_() {
        String smallNumString = "-1";
        takeValAsInputAndLookForOutputPrefix(smallNumString, "Error: Number " + smallNumString + " is too small ");
    }
}
