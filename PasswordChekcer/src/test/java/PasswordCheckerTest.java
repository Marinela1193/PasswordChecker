import org.example.PasswordChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PasswordCheckerTest {
    @Test
    void passwordCorrect() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckDigits(true);
        checker.setCheckUppers(true);
        checker.setCheckLowers(true);
        int resultado = checker.check("Abcde1234", "Abcde1234");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test
    void passwordNoMatch() {
        PasswordChecker checker = new PasswordChecker();

        int resultado = checker.check("Abcde1234", "Abcde1236");
        assertEquals(PasswordChecker.ERR_NO_MATCH, resultado);
    }

    @Test
    void invalidMinlength() {
        PasswordChecker checker = new PasswordChecker();

        try {

            checker.setMinLength(0);

            fail("Se esperaba una IllegalArgumentException");

        } catch (IllegalArgumentException e) {

            assertEquals(
                    PasswordChecker.ERR_INVALID_MIN_LENGTH,
                    e.getMessage()
            );
        }
        //comprobamos el borderline
        checker.setMinLength(1);

        assertEquals(
                1,
                checker.getMinLength()
        );
    }

    @Test
    void invalidMaxLength() {
        PasswordChecker checker = new PasswordChecker();
        //comprobamos el borderline
        try {
            checker.setMaxLength(7);
            fail("Se esperaba una IllegalArgumentException");

        } catch (IllegalArgumentException e) {

            assertEquals(
                    PasswordChecker.ERR_INVALID_MAX_LENGTH,
                    e.getMessage()
            );
        }

        //comprobamos que si utilizamos longitud igual o mayor va bien.
        checker.setMaxLength(8);

        assertEquals(
                8,
                checker.getMaxLength()
        );

        checker.setMaxLength(9);

        assertEquals(
                9,
                checker.getMaxLength()
        );
    }

    @Test
    void passwordTooShort() {
        PasswordChecker checker = new PasswordChecker();

        int resultado = checker.check("Abc123", "Abc123");

        assertEquals(
                PasswordChecker.ERR_LENGTH,
                resultado
        );
    }

    @Test
    void passwordTooLong() {
        PasswordChecker checker = new PasswordChecker();

        checker.setMaxLength(10);

        int resultado = checker.check(
                "Abcdef12345",
                "Abcdef12345"
        );

        assertEquals(
                PasswordChecker.ERR_LENGTH,
                resultado
        );
    }

    @Test
    void passwordEmpty() {
        PasswordChecker checker = new PasswordChecker();
        int resultado = checker.check("", "");
        assertEquals(PasswordChecker. ERR_BLANK, resultado);
    }

    @Test
    void passwordNoUppers(){
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckUppers(true);

        int resultado = checker.check("abcde1234", "abcde1234");
        assertEquals(PasswordChecker. ERR_UPPERS, resultado);
    }

    @Test
    void passwordNoLowers(){
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckLowers(true);

        int resultado = checker.check("ABCDE1234", "ABCDE1234");
        assertEquals(PasswordChecker. ERR_LOWERS, resultado);
    }

    @Test
    void passwordWithoutNumbers() {
        PasswordChecker checker = new PasswordChecker();
        checker.setCheckDigits(true);

        int resultado = checker.check("ABCDEfghi", "ABCDEfghi");
        assertEquals(PasswordChecker. ERR_DIGITS, resultado);
    }



}
