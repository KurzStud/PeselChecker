import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private String correctPesel;
    private String tooShortPesel;
    private String incorrectPesel;


    @BeforeEach
    void setUp() {
      correctPesel = "80081837841";
      tooShortPesel = "800818";
      incorrectPesel = "12345678909";
    }

    @Test
    @DisplayName("Should pass when method return false in fact of wrong checksum")
    public void shouldPassWhenIncorrectPeselIsGiven(){
        boolean correctness = Validator.validatePesel(incorrectPesel);
        Assertions.assertFalse(correctness);
    }

    @Test
    @DisplayName("Should pass when method return false in fact of too short pesel.")
    public void shouldPassWhenPeselTooShort(){
        boolean correctness = Validator.validatePesel(tooShortPesel);
        Assertions.assertFalse(correctness);
    }

    @Test
    @DisplayName("Should pass when method return true in fact of correct pesel.")
    public void shouldPassWhenPeselIsCorrect(){
        boolean correctness = Validator.validatePesel(correctPesel);
        Assertions.assertTrue(correctness);
    }
}