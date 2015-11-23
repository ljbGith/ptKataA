import com.pillarescent.ArabicRomanIO;

import junit.framework.TestCase;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.StringWriter;


public class ArabicRomanIOTest {
    @Test
    public void doInputGetSomeKindOfOutput() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("1", outputSink);
        io.handleInputs();
        String output = outputSink.toString();
        junit.framework.TestCase.assertFalse(output.length() == 0);
    }
    @Test
    public void take1asInputAndOutputI() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("1", outputSink);
        io.handleInputs();
        String output = outputSink.toString().replaceAll("\\s+$", "");
        assertEquals("I", output);
    }
    @Test
    public void take3999asInputAndOutputMMMCMXCIX() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("3999", outputSink);
        io.handleInputs();
        String output = outputSink.toString().replaceAll("\\s+$", "");
        assertEquals("MMMCMXCIX", output);
    }
    @Test
    public void takeNoInputAndOutput_NOTHING_() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("", outputSink);
        io.handleInputs();
        String output = outputSink.toString().replaceAll("\\s+$", "");
        assertEquals("", output);
    }
    @Test
    public void takeNonNumericInputAndOutput_ErrorMessage_() {
        StringWriter outputSink = new StringWriter();
        ArabicRomanIO io = new ArabicRomanIO("zzz", outputSink);
        io.handleInputs();
        String output = outputSink.toString().replaceAll("\\s+$", "");
        assertTrue(output.startsWith("Error: expected a regular number "));
    }
}
