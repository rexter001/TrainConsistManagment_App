import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC9Test {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("Sleeper", 72));
        bogies.add(new UC9.Bogie("Sleeper", 70));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("AC Chair", 56));
        bogies.add(new UC9.Bogie("AC Chair", 60));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("Sleeper", 72));
        bogies.add(new UC9.Bogie("AC Chair", 56));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UC9.Bogie> bogies = new ArrayList<>();

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("Sleeper", 72));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("First Class", 24));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("Sleeper", 72));
        bogies.add(new UC9.Bogie("Sleeper", 70));

        Map<String, List<UC9.Bogie>> result = UC9.groupBogies(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UC9.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC9.Bogie("Sleeper", 72));

        UC9.groupBogies(bogies);

        assertEquals(1, bogies.size());
    }
}