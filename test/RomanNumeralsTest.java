import com.pillarescent.RomanNumerals;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralsTest {
    @Test
    public void whenInputIs1OutputIsASingleI() {
        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("I", romanNumerals.fromArabic(1));
    }
    @Test
    public void whenInputIs2OutputIsII() {
        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("II", romanNumerals.fromArabic(2));
    }
}
