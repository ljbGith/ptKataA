import com.pillarescent.ArabicRomanIO;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

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
}
