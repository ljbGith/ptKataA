import com.pillarescent.ArabicRomanIO;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.StringWriter;


public class ArabicRomanIOTest {

    protected static final String newLine = System.lineSeparator();

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
        String input = "1" + newLine + "2" + newLine + "3";
        String expectedOutput = "I" + newLine + "II" + newLine + "III";
        takeValueAsInputAndLookForSpecificOutput(input, expectedOutput);
    }
    @Test
    public void takeQuitOnFirstLineAndOutput_NOTHING_() {
        takeValueAsInputAndLookForSpecificOutput("quit", "");
    }
    @Test
    public void take11OnFirstLineAndQuitOnSecondLineAndOutputXI() {
        String input = "11" + newLine + "quit";
        takeValueAsInputAndLookForSpecificOutput(input, "XI");
    }
    @Test
    public void take11OnFirstLineQuitOnSecondLineAnd12OnThirdLineAndOutputXI() {
        // Illustrates that as soon as "quit" line is seen, processing stops.
        // The lack of handling of "12" models the exiting of the program in interactive mode.
        String input = "11" + newLine + "quit" + newLine + "12";
        takeValueAsInputAndLookForSpecificOutput(input, "XI");
    }
}
