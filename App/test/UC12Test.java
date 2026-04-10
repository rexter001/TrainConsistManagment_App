import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UC12Test {

    @Test
    void testSafety_AllBogiesValid() {
        List<UC12.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UC12.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UC12.GoodsBogie("Box", "Grain"));

        assertTrue(UC12.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UC12.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UC12.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(UC12.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<UC12.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UC12.GoodsBogie("Open", "Coal"));
        bogies.add(new UC12.GoodsBogie("Box", "Grain"));

        assertTrue(UC12.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<UC12.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UC12.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UC12.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(UC12.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<UC12.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(UC12.isTrainSafe(bogies));
    }
}