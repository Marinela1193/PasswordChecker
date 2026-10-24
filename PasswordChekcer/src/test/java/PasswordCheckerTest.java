import org.example.PasswordChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCheckerTest {
    @Test
    void passwordCorrect() {
        PasswordChecker checker = new PasswordChecker();
        int resultado = checker.check("abcde123", "abcde123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test
    void passwordIncorrect() {
        PasswordChecker checker = new PasswordChecker();

    }

    @Test
    void passwordTooShort() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordTooLong() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordEmpty() {
        PasswordChecker checker = new PasswordChecker();

    }

    @Test
    void passwordNoMayus(){

    }

    @Test
    void passwordMinusAndMayus(){

    }

    @Test
    void passwordWithoutNumbers() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordWithoutLetters() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordWithoutSpecialCharacters() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordWithLettersButNoNumbers() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordWithLettersButNoSpecialCharacters() {
        PasswordChecker checker = new PasswordChecker();
    }

    @Test
    void passwordWithSpecialCharactersButNoNumbers() {

    }
    @Test
    void passwordWithSpecialCharactersButNoLetters() {

    }

    @Test
    void passwordWithNumbersButNoLetters() {

    }

    @Test
    void passwordwithNumbersButNoSpecialCharacters() {

    }

}
