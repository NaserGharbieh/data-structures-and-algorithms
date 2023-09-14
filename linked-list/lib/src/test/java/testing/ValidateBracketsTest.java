package testing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stack.Validatebrackets;

public class ValidateBracketsTest{
    @Test
    void testValidBrackets() {
        Validatebrackets validator = new Validatebrackets();

        assertTrue(validator.validateBrackets("{}"));
        assertTrue(validator.validateBrackets("{}(){}"));
        assertTrue(validator.validateBrackets("()[[Extra Characters]]"));
        assertTrue(validator.validateBrackets("(){}[[]]"));
        assertTrue(validator.validateBrackets("{}{Code}[Fellows](())"));
    }

    @Test
    void testInvalidBrackets() {
        Validatebrackets validator = new Validatebrackets();

        assertFalse(validator.validateBrackets("[({}]"));
        assertFalse(validator.validateBrackets("(]"));
        assertFalse(validator.validateBrackets("{(})"));
    }

    @Test
    void testEmptyString() {
        Validatebrackets validator = new Validatebrackets();

        assertTrue(validator.validateBrackets(""));
    }

    @Test
    void testOnlyOpeningBrackets() {
        Validatebrackets validator = new Validatebrackets();

        assertFalse(validator.validateBrackets("{[("));
    }

    @Test
    void testOnlyClosingBrackets() {
        Validatebrackets validator = new Validatebrackets();

        assertFalse(validator.validateBrackets("})]"));
    }

    @Test
    void testMixedBrackets() {
        Validatebrackets validator = new Validatebrackets();

        assertFalse(validator.validateBrackets("{[)]"));
    }


}
