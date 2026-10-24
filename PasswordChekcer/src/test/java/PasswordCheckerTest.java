import org.example.PasswordChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckerTest {
    @Test
    void passwordCorrecto() {
        PasswordChecker checker = new PasswordChecker();
        int resultado = checker.check("abcde123", "abcde123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }
}
