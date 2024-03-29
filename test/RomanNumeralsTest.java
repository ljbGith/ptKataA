import com.pillarescent.CommonRoman.RomanNumerals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class RomanNumeralsTest {
    @Test
    public void whenInputIs1OutputIsASingleI() {
        assertEquals("I", RomanNumerals.fromArabic(1));
    }
    @Test
    public void whenInputIs2OutputIsII() {
        assertEquals("II", RomanNumerals.fromArabic(2));
    }
    @Test
    public void whenInputIs3OutputIsIII() {
        assertEquals("III", RomanNumerals.fromArabic(3));
    }
    @Test
    public void whenInputIs4OutputDoesNotContainMoreThan3IsInARow() {
        String romanFor4 = RomanNumerals.fromArabic(4);
        assertFalse(romanFor4.contains("IIII"));
    }
    @Test
    public void whenInputIs4OutputIsIV() {
        assertEquals("IV", RomanNumerals.fromArabic(4));
    }
    @Test
    public void whenInputIs157OutputIsCLVII() {
        String romanFor157 = RomanNumerals.fromArabic(157);
        assertEquals("CLVII", romanFor157);
    }
    @Test
    public void whenInputIs9OutputIsIX() {
        String romanFor9 = RomanNumerals.fromArabic(9);
        assertEquals("IX", romanFor9);
    }
    @Test
    public void whenInputIs14OutputIsXIV() { assertEquals("XIV", RomanNumerals.fromArabic(14)); }
    @Test
    public void whenInputIs29OutputIsXXIX() { assertEquals("XXIX", RomanNumerals.fromArabic(29)); }
    @Test
    public void whenInputIs48OutputIsXLVIII() { assertEquals("XLVIII", RomanNumerals.fromArabic(48)); }
    @Test
    public void whenInputIs84OutputIsLXXXIV() { assertEquals("LXXXIV", RomanNumerals.fromArabic(84)); }
    @Test
    public void whenInputIs90OutputIsXC() { assertEquals("XC", RomanNumerals.fromArabic(90)); }
    @Test
    public void whenInputIs149OutputIsCXLIX() { assertEquals("CXLIX", RomanNumerals.fromArabic(149)); }
    @Test
    public void whenInputIs399OutputIsCCCXCIX() { assertEquals("CCCXCIX", RomanNumerals.fromArabic(399)); }
    @Test
    public void whenInputIs888OutputIsDCCCLXXX() { assertEquals("DCCCLXXXVIII", RomanNumerals.fromArabic(888)); }
    @Test
    public void whenInputIs3444OutputIsMMMCDXLIV() { assertEquals("MMMCDXLIV", RomanNumerals.fromArabic(3444)); }
    @Test
    public void whenInputIs3888OutputIsMMMDCCCLXXXVIII() {
        assertEquals("MMMDCCCLXXXVIII", RomanNumerals.fromArabic(3888));
    }
    /* BOUNDARY TESTS */
    @Test
    public void whenInputIs0OutputIs_Empty_() {
        assertEquals("", RomanNumerals.fromArabic(0));
    }

    /* ALREADY DID 1, 4, 9 ABOVE. */

    // Boundary case - 1 I after other numerals.
    @Test
    public void whenInputIs6OutputIsVI() { assertEquals("VI", RomanNumerals.fromArabic(6)); }

    // Boundary case - 3 I's after other numerals.
    @Test
    public void whenInputIs8OutputIsVIII() { assertEquals("VIII", RomanNumerals.fromArabic(8)); }

    // More boundary cases.
    @Test
    public void whenInputIs10OutputIsX() { assertEquals("X", RomanNumerals.fromArabic(10)); }
    @Test
    public void whenInputIs15OutputIsXV() { assertEquals("XV", RomanNumerals.fromArabic(15)); }
    @Test
    public void whenInputIs19OutputIsXIX() { assertEquals("XIX", RomanNumerals.fromArabic(19)); }
    @Test
    public void whenInputIs39OutputIsXXXIX() { assertEquals("XXXIX", RomanNumerals.fromArabic(39)); }
    @Test
    public void whenInputIs49OutputIsXLIX() { assertEquals("XLIX", RomanNumerals.fromArabic(49)); }
    @Test
    public void whenInputIs50OutputIsL() { assertEquals("L", RomanNumerals.fromArabic(50)); }
    @Test
    public void whenInputIs51OutputIsLI() { assertEquals("LI", RomanNumerals.fromArabic(51)); }
    @Test
    public void whenInputIs54OutputIsLIV() { assertEquals("LIV", RomanNumerals.fromArabic(54)); }
    @Test
    public void whenInputIs98OutputIsXCVIII() { assertEquals("XCVIII", RomanNumerals.fromArabic(98)); }
    @Test
    public void whenInputIs99OutputIsXCIX() { assertEquals("XCIX", RomanNumerals.fromArabic(99)); }
    @Test
    public void whenInputIs100OutputIsC() { assertEquals("C", RomanNumerals.fromArabic(100)); }
    @Test
    public void whenInputIs101OutputIsCI() { assertEquals("CI", RomanNumerals.fromArabic(101)); }
    @Test
    public void whenInputIs110OutputIsCX() { assertEquals("CX", RomanNumerals.fromArabic(110)); }
    @Test
    public void whenInputIs111OutputIsCXI() { assertEquals("CXI", RomanNumerals.fromArabic(111)); }
    @Test
    public void whenInputIs222OutputIsCCXXII() { assertEquals("CCXXII", RomanNumerals.fromArabic(222)); }
    @Test
    public void whenInputIs333OutputIsCCCXXXIII() { assertEquals("CCCXXXIII", RomanNumerals.fromArabic(333)); }
    @Test
    public void whenInputIs444OutputIsCDXLIV() { assertEquals("CDXLIV", RomanNumerals.fromArabic(444)); }
    @Test
    public void whenInputIs499OutputIsDLV() { assertEquals("CDXCIX", RomanNumerals.fromArabic(499)); }
    @Test
    public void whenInputIs500OutputIsDLV() { assertEquals("D", RomanNumerals.fromArabic(500)); }
    @Test
    public void whenInputIs555OutputIsDLV() { assertEquals("DLV", RomanNumerals.fromArabic(555)); }
    @Test
    public void whenInputIs888OutputIsDCCCLXXXVIII() { assertEquals("DCCCLXXXVIII", RomanNumerals.fromArabic(888)); }
    @Test
    public void whenInputIs999OutputIsCMXCIX() { assertEquals("CMXCIX", RomanNumerals.fromArabic(999)); }
    @Test
    public void whenInputIs1000OutputIsM() { assertEquals("M", RomanNumerals.fromArabic(1000)); }
    @Test
    public void whenInputIs1001OutputIsMI() { assertEquals("MI", RomanNumerals.fromArabic(1001)); }
    @Test
    public void whenInputIs1499OutputIsMCDXCIX() { assertEquals("MCDXCIX", RomanNumerals.fromArabic(1499)); }
    @Test
    public void whenInputIs1500OutputIsMD() { assertEquals("MD", RomanNumerals.fromArabic(1500)); }
    @Test
    public void whenInputIs1888OutputIsMDCCCLXXXVIII() { assertEquals("MDCCCLXXXVIII", RomanNumerals.fromArabic(1888)); }
    @Test
    public void whenInputIs1999OutputIsMCMXCIX() { assertEquals("MCMXCIX", RomanNumerals.fromArabic(1999)); }
    @Test
    public void whenInputIs2000OutputIsMM() { assertEquals("MM", RomanNumerals.fromArabic(2000)); }
    @Test
    public void whenInputIs3000OutputIsMMM() { assertEquals("MMM", RomanNumerals.fromArabic(3000)); }
    @Test
    public void whenInputIs3333OutputIsMMMCCCXXXIII() { assertEquals("MMMCCCXXXIII", RomanNumerals.fromArabic(3333)); }
    /* ALREADY TESTED 3888. */
    @Test
    public void whenInputIs3900OutputIsMMMCM() { assertEquals("MMMCM", RomanNumerals.fromArabic(3900)); }
    @Test
    public void whenInputIs3999OutputIsMMMCMXCIX() { assertEquals("MMMCMXCIX", RomanNumerals.fromArabic(3999)); }

    /* "WEIRD" OR "ILLEGAL" INPUTS */

    // 0 -> "" (revisit requirements and sanity-check this case with customer if possible).
    @Test
    public void whenInputIs0OutputIs_Blank_() { assertEquals("", RomanNumerals.fromArabic(0)); }

    @Rule
    public final ExpectedException exceptionThrown = ExpectedException.none();
    @Test
    public void whenInputIs4000ThrowsException() {
        String romanFor4000 = RomanNumerals.fromArabic(4000);
        assertEquals("Error: Number 4000 is too large for Roman numeral representation.", romanFor4000);
    }
    @Test
    public void whenInputIsMinus1ThrowsException() {
        String romanForMinus1 = RomanNumerals.fromArabic(-1);
        assertEquals("Error: Number -1 is too small for Roman numeral representation.", romanForMinus1);
    }

    // ROMAN TO ARABIC TEST CASES

    private void testToArabic(int expectedArabic, String romanInput) {
         assertEquals(expectedArabic, RomanNumerals.toArabic(romanInput));
    }

    // NORMAL CASES
    @Test
    public void whenInputIsIOutputIs1() { testToArabic(1, "I"); }
    @Test
    public void whenInputIsIIOutputIs2() { testToArabic(2, "II"); }
    @Test
    public void whenInputIsIIIOutputIs3() { testToArabic(3, "III"); }
    @Test
    public void whenInputIsIVOutputIs4() { testToArabic(4, "IV"); }
    @Test
    public void whenInputIsIVOutputIs5() { testToArabic(5, "V"); }
    @Test
    public void whenInputIsIVOutputIs6() { testToArabic(6, "VI"); }
    @Test
    public void whenInputIsIVOutputIs8() { testToArabic(8, "VIII"); }
    @Test
    public void whenInputIsIXOutputIs9() { testToArabic(9, "IX"); }
    @Test
    public void whenInputIsXOutputIs10() { testToArabic(10, "X"); }
    @Test
    public void whenInputIsXIVOutputIs14() { testToArabic(14, "XIV"); }
    @Test
    public void whenInputIsXXIXOutputIs29() { testToArabic(29, "XXIX"); }
    @Test
    public void whenInputIsXLOutputIs40() { testToArabic(40, "XL"); }
    @Test
    public void whenInputIsXLVIIIOutputIs48() { testToArabic(48, "XLVIII"); }
    @Test
    public void whenInputIsLXXXIVOutputIs84() { testToArabic(84, "LXXXIV"); }
    @Test
    public void whenInputIsXCOutputIs90() { testToArabic(90, "XC"); }
    @Test
    public void whenInputIsCXIOutputIs111() { testToArabic(111, "CXI"); }
    @Test
    public void whenInputIsCXLIXOutputIs149() { testToArabic(149, "CXLIX"); }
    @Test
    public void whenInputIsCLVIIOutputIs157() { testToArabic(157, "CLVII"); }
    @Test
    public void whenInputIsCCXXIIOutputIs222() { testToArabic(222, "CCXXII"); }
    @Test
    public void whenInputIsCCCXXXIIIOutputIs333() { testToArabic(333, "CCCXXXIII"); }
    @Test
    public void whenInputIsCCCXCIXOutputIs399() { testToArabic(399, "CCCXCIX"); }
    @Test
    public void whenInputIsCDOutputIs400() { testToArabic(400, "CD"); }
    @Test
    public void whenInputIsCDXLIVOutputIs444() { testToArabic(444, "CDXLIV"); }
    @Test
    public void whenInputIsDLVOutputIs499() { testToArabic(499, "CDXCIX"); }
    @Test
    public void whenInputIsDLVOutputIs500() { testToArabic(500, "D"); }
    @Test
    public void whenInputIsDLVOutputIs555() { testToArabic(555, "DLV"); }
    @Test
    public void whenInputIsDCCCLXXXVIIIOutputIs888() { testToArabic(888, "DCCCLXXXVIII"); }
    @Test
    public void whenInputIsCMXCIXOutputIs999() { testToArabic(999, "CMXCIX"); }
    @Test
    public void whenInputIsCMOutputIs900() { testToArabic(900, "CM"); }
    @Test
    public void whenInputIsMOutputIs1000() { testToArabic(1000, "M"); }
    @Test
    public void whenInputIsMIOutputIs1001() { testToArabic(1001, "MI"); }
    @Test
    public void whenInputIsMCDXCIXOutputIs1499() { testToArabic(1499, "MCDXCIX"); }
    @Test
    public void whenInputIsMDOutputIs1500() { testToArabic(1500, "MD"); }
    @Test
    public void whenInputIsMDCCCLXXXVIIIOutputIs1888() { testToArabic(1888, "MDCCCLXXXVIII"); }
    @Test
    public void whenInputIsMCMXCIXOutputIs1999() { testToArabic(1999, "MCMXCIX"); }
    @Test
    public void whenInputIsMMOutputIs2000() { testToArabic(2000, "MM"); }
    @Test
    public void whenInputIsMMMOutputIs3000() { testToArabic(3000, "MMM"); }
    @Test
    public void whenInputIsMMMCCCXXXIIIOutputIs3333() { testToArabic(3333, "MMMCCCXXXIII"); }
    @Test
    public void whenInputIsMMMCDXLIVOutputIs3444() { testToArabic(3444, "MMMCDXLIV"); }
    @Test
    public void whenInputIsMMMDCCCLXXXVIIIOutputIs3888() { testToArabic(3888, "MMMDCCCLXXXVIII"); }
    @Test
    public void whenInputIsMMMCMOutputIs3900() { testToArabic(3900, "MMMCM"); }
    @Test
    public void whenInputIsMMMCMXCIXOutputIs3999() { testToArabic(3999, "MMMCMXCIX"); }

    // BAD-ROMAN CASES
    @Test
    public void whenInputIsMMMMOutputIs_Error_() { testToArabic(-1, "MMMM"); }
    @Test
    public void whenInputIsZZZZOutputIs_Error_() { testToArabic(-1, "ZZZZ"); }

}
