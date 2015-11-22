import com.pillarescent.RomanNumerals;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class RomanNumeralsTest {
    RomanNumerals romanNumerals; // To be initialized in each test!
    @Before
    public void setUp() {
        romanNumerals = new RomanNumerals();
    }
    @Test
    public void whenInputIs1OutputIsASingleI() {
        assertEquals("I", romanNumerals.fromArabic(1));
    }
    @Test
    public void whenInputIs2OutputIsII() {
        assertEquals("II", romanNumerals.fromArabic(2));
    }
    @Test
    public void whenInputIs3OutputIsIII() {
        assertEquals("III", romanNumerals.fromArabic(3));
    }
    @Test
    public void whenInputIs4OutputDoesNotContainMoreThan3IsInARow() {
        String romanFor4 = romanNumerals.fromArabic(4);
        assertFalse(romanFor4.contains("IIII"));
    }
    @Test
    public void whenInputIs157OutputIsCLVII() {
        String romanFor157 = romanNumerals.fromArabic(157);
        assertEquals("CLVII", romanFor157);
    }
}
