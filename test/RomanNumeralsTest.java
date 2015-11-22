import org.junit.Test;
// [NON-COMPILING CODE COMMITTED ONLY TO SHOW FAILURE OF EXISTENCE OF APPLICATION CLASS.]
public class RomanNumeralsTest {
    @Test
    public void whenInputIs1OutputIsASingleI() {
        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals("I", romanNumerals.fromArabic(1));
    }
}
