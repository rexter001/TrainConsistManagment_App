import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC14Test {

    @Test
    void testException_ValidCapacityCreation()
            throws UC14.InvalidCapacityException {

        UC14.PassengerBogie bogie =
                new UC14.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(
                UC14.InvalidCapacityException.class,
                () -> new UC14.PassengerBogie("Sleeper", -10)
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                UC14.InvalidCapacityException.class,
                () -> new UC14.PassengerBogie("Sleeper", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                UC14.InvalidCapacityException.class,
                () -> new UC14.PassengerBogie("Sleeper", 0)
        );

        assertEquals(
                "Capacity must be greater than zero",
                exception.getMessage()
        );
    }

    @Test
    void testException_ObjectIntegrityAfterCreation()
            throws UC14.InvalidCapacityException {

        UC14.PassengerBogie bogie =
                new UC14.PassengerBogie("AC Chair", 56);

        assertEquals("AC Chair", bogie.type);
        assertEquals(56, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation()
            throws UC14.InvalidCapacityException {

        UC14.PassengerBogie b1 =
                new UC14.PassengerBogie("Sleeper", 72);

        UC14.PassengerBogie b2 =
                new UC14.PassengerBogie("AC Chair", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}