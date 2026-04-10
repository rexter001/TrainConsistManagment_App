import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC15Test {

    @Test
    void testCargo_SafeAssignment() {
        UC15.GoodsBogie bogie =
                new UC15.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UC15.GoodsBogie bogie =
                new UC15.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UC15.GoodsBogie bogie =
                new UC15.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UC15.GoodsBogie b1 =
                new UC15.GoodsBogie("Rectangular");

        UC15.GoodsBogie b2 =
                new UC15.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Coal");

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UC15.GoodsBogie bogie =
                new UC15.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertTrue(bogie.validationCompleted);
    }
}