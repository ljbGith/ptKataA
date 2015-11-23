import com.pillarescent.RomanNumerals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void whenInputIs14OutputIsXIV() { assertEquals("XIV", romanNumerals.fromArabic(14)); }
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
    public void whenInputIs3888OutputIsMMMDCCCLXXXVIII() {
        assertEquals("MMMDCCCLXXXVIII", romanNumerals.fromArabic(3888));
    }
    /* BOUNDARY TESTS */
    @Test
    public void whenInputIs0OutputIs_Empty_() {
        assertEquals("", romanNumerals.fromArabic(0));
    }

    /* ALREADY DID 1, 4, 9 ABOVE. */

    // Boundary case - 1 I after other numerals.
    @Test
    public void whenInputIs6OutputIsVI() { assertEquals("VI", romanNumerals.fromArabic(6)); }

    // Boundary case - 3 I's after other numerals.
    @Test
    public void whenInputIs8OutputIsVIII() { assertEquals("VIII", romanNumerals.fromArabic(8)); }

    // More boundary cases.
    @Test
    public void whenInputIs10OutputIsX() { assertEquals("X", romanNumerals.fromArabic(10)); }
    @Test
    public void whenInputIs15OutputIsXV() { assertEquals("XV", romanNumerals.fromArabic(15)); }
    @Test
    public void whenInputIs19OutputIsXIX() { assertEquals("XIX", romanNumerals.fromArabic(19)); }
    @Test
    public void whenInputIs39OutputIsXXXIX() { assertEquals("XXXIX", romanNumerals.fromArabic(39)); }
    @Test
    public void whenInputIs49OutputIsXLIX() { assertEquals("XLIX", romanNumerals.fromArabic(49)); }
    @Test
    public void whenInputIs50OutputIsL() { assertEquals("L", romanNumerals.fromArabic(50)); }
    @Test
    public void whenInputIs51OutputIsLI() { assertEquals("LI", romanNumerals.fromArabic(51)); }
    @Test
    public void whenInputIs54OutputIsLIV() { assertEquals("LIV", romanNumerals.fromArabic(54)); }
    @Test
    public void whenInputIs98OutputIsXCVIII() { assertEquals("XCVIII", romanNumerals.fromArabic(98)); }
    @Test
    public void whenInputIs99OutputIsXCIX() { assertEquals("XCIX", romanNumerals.fromArabic(99)); }
    @Test
    public void whenInputIs100OutputIsC() { assertEquals("C", romanNumerals.fromArabic(100)); }
    @Test
    public void whenInputIs101OutputIsCI() { assertEquals("CI", romanNumerals.fromArabic(101)); }
    @Test
    public void whenInputIs110OutputIsCX() { assertEquals("CX", romanNumerals.fromArabic(110)); }
    @Test
    public void whenInputIs111OutputIsCXI() { assertEquals("CXI", romanNumerals.fromArabic(111)); }
    @Test
    public void whenInputIs222OutputIsCCXXII() { assertEquals("CCXXII", romanNumerals.fromArabic(222)); }
    @Test
    public void whenInputIs333OutputIsCCCXXXIII() { assertEquals("CCCXXXIII", romanNumerals.fromArabic(333)); }
    @Test
    public void whenInputIs444OutputIsCDXLIV() { assertEquals("CDXLIV", romanNumerals.fromArabic(444)); }
    @Test
    public void whenInputIs499OutputIsDLV() { assertEquals("CDXCIX", romanNumerals.fromArabic(499)); }
    @Test
    public void whenInputIs500OutputIsDLV() { assertEquals("D", romanNumerals.fromArabic(500)); }
    @Test
    public void whenInputIs555OutputIsDLV() { assertEquals("DLV", romanNumerals.fromArabic(555)); }
    @Test
    public void whenInputIs888OutputIsDCCCLXXXVIII() { assertEquals("DCCCLXXXVIII", romanNumerals.fromArabic(888)); }
    @Test
    public void whenInputIs999OutputIsCMXCIX() { assertEquals("CMXCIX", romanNumerals.fromArabic(999)); }
    @Test
    public void whenInputIs1000OutputIsM() { assertEquals("M", romanNumerals.fromArabic(1000)); }
    @Test
    public void whenInputIs1001OutputIsMI() { assertEquals("MI", romanNumerals.fromArabic(1001)); }
    @Test
    public void whenInputIs1499OutputIsMCDXCIX() { assertEquals("MCDXCIX", romanNumerals.fromArabic(1499)); }
    @Test
    public void whenInputIs1500OutputIsMD() { assertEquals("MD", romanNumerals.fromArabic(1500)); }
    @Test
    public void whenInputIs1888OutputIsMDCCCLXXXVIII() { assertEquals("MDCCCLXXXVIII", romanNumerals.fromArabic(1888)); }
    @Test
    public void whenInputIs1999OutputIsMCMXCIX() { assertEquals("MCMXCIX", romanNumerals.fromArabic(1999)); }
    @Test
    public void whenInputIs2000OutputIsMM() { assertEquals("MM", romanNumerals.fromArabic(2000)); }
    @Test
    public void whenInputIs3000OutputIsMMM() { assertEquals("MMM", romanNumerals.fromArabic(3000)); }
    @Test
    public void whenInputIs3333OutputIsMMMCCCXXXIII() { assertEquals("MMMCCCXXXIII", romanNumerals.fromArabic(3333)); }
    /* ALREADY TESTED 3888. */
    @Test
    public void whenInputIs3900OutputIsMMMCM() { assertEquals("MMMCM", romanNumerals.fromArabic(3900)); }
    @Test
    public void whenInputIs3999OutputIsMMMCMXCIX() { assertEquals("MMMCMXCIX", romanNumerals.fromArabic(3999)); }

    /* "WEIRD" OR "ILLEGAL" INPUTS */

    // 0 -> "" (revisit requirements and sanity-check this case with customer if possible).
    @Test
    public void whenInputIs0OutputIs_Blank_() { assertEquals("", romanNumerals.fromArabic(0)); }

    @Rule
    public final ExpectedException exceptionThrown = ExpectedException.none();
    @Test
    public void whenInputIs4000ThrowsException() {
        String romanFor4000 = romanNumerals.fromArabic(4000);
        assertEquals("Error: Number 4000 is too large for Roman numeral representation.", romanFor4000);
    }
    @Test
    public void whenInputIsMinus1ThrowsException() {
        String romanForMinus1 = romanNumerals.fromArabic(-1);
        assertEquals("Error: Number -1 is too small for Roman numeral representation.", romanForMinus1);
    }

}
