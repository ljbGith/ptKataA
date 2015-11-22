import com.pillarescent.RomanNumerals;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

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
    @Test
    public void whenInputIs3OutputIsIII() {
        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("III", romanNumerals.fromArabic(3));
    }
    @Test
    public void whenInputIs4OutputDoesNotContainMoreThan3IsInARow() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String romanFor4 = romanNumerals.fromArabic(4);
        assertFalse(romanFor4.contains("IIII"));
    }
    @Test
    public void whenInputIs157OutputIsCLVII() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String romanFor157 = romanNumerals.fromArabic(157);
        assertEquals("CLVII", romanFor157);
    }
}
