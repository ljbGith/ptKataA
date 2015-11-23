import com.pillarescent.RomanNumerals;
import junit.framework.Assert;
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
    public void whenInputIs4OutputIsIV() {
        assertEquals("IV", romanNumerals.fromArabic(4));
    }
    @Test
    public void whenInputIs157OutputIsCLVII() {
        String romanFor157 = romanNumerals.fromArabic(157);
        assertEquals("CLVII", romanFor157);
    }
    @Test
    public void whenInputIs9OutputIsIX() {
        String romanFor9 = romanNumerals.fromArabic(9);
        assertEquals("IX", romanFor9);
    }
    @Test
    public void whenInputIs14OutputIsXIV() { assertEquals("XIV",  romanNumerals.fromArabic(14)); }
    @Test
    public void whenInputIs29OutputIsXXIX() { assertEquals("XXIX", romanNumerals.fromArabic(29)); }
    @Test
    public void whenInputIs48OutputIsXLVIII() { assertEquals("XLVIII", romanNumerals.fromArabic(48)); }
    @Test
    public void whenInputIs84OutputIsLXXXIV() { assertEquals("LXXXIV", romanNumerals.fromArabic(84)); }
    @Test
    public void whenInputIs90OutputIsXC() { assertEquals("XC", romanNumerals.fromArabic(90)); }
    @Test
    public void whenInputIs149OutputIsCXLIX() { assertEquals("CXLIX", romanNumerals.fromArabic(149)); }
    @Test
    public void whenInputIs399OutputIsCCCXCIX() { assertEquals("CCCXCIX", romanNumerals.fromArabic(399)); }
    @Test
    public void whenInputIs888OutputIsDCCCLXXX() { assertEquals("DCCCLXXXVIII", romanNumerals.fromArabic(888)); }
    @Test
    public void whenInputIs3444OutputIsMMMCDXLIV() { assertEquals("MMMCDXLIV", romanNumerals.fromArabic(3444)); }
    @Test
    public void whenInputIs3888OutputIsMMMDCCCLXXXVIII() { assertEquals("MMMDCCCLXXXVIII", romanNumerals.fromArabic(3888)); }
    @Test
    public void whenInputIs3999OutputIsMMMCMXCIX() { assertEquals("MMMCMXCIX", romanNumerals.fromArabic(3999)); }
}
