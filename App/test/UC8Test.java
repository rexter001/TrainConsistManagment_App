import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UC8Test {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("Sleeper", 72));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("AC Chair", 70));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("First Class", 24));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("Sleeper", 72));
        bogies.add(new UC8.Bogie("General", 90));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("First Class", 24));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("Sleeper", 80));
        bogies.add(new UC8.Bogie("General", 90));

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UC8.Bogie> bogies = new ArrayList<>();

        List<UC8.Bogie> result = UC8.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UC8.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC8.Bogie("Sleeper", 72));

        UC8.filterBogies(bogies, 70);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}
