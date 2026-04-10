import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11Test {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UC11.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UC11.isValidTrainId("TRAIN12"));
        assertFalse(UC11.isValidTrainId("TRN12A"));
        assertFalse(UC11.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UC11.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UC11.isValidCargoCode("PET-ab"));
        assertFalse(UC11.isValidCargoCode("PET123"));
        assertFalse(UC11.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UC11.isValidTrainId("TRN-123"));
        assertFalse(UC11.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UC11.isValidCargoCode("PET-aB"));
        assertFalse(UC11.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UC11.isValidTrainId(""));
        assertFalse(UC11.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UC11.isValidTrainId("XXTRN-1234"));
        assertFalse(UC11.isValidCargoCode("PET-ABCD"));
    }
}