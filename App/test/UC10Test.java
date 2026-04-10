import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UC10Test {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("Sleeper", 72));
        bogies.add(new UC10.Bogie("AC Chair", 56));

        int result = UC10.totalSeats(bogies);

        assertEquals(128, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("Sleeper", 72));
        bogies.add(new UC10.Bogie("AC Chair", 56));
        bogies.add(new UC10.Bogie("First Class", 24));

        int result = UC10.totalSeats(bogies);

        assertEquals(152, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("Sleeper", 72));

        int result = UC10.totalSeats(bogies);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UC10.Bogie> bogies = new ArrayList<>();

        int result = UC10.totalSeats(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("AC Chair", 56));

        int result = UC10.totalSeats(bogies);

        assertEquals(56, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("Sleeper", 72));
        bogies.add(new UC10.Bogie("AC Chair", 56));
        bogies.add(new UC10.Bogie("First Class", 24));
        bogies.add(new UC10.Bogie("Sleeper", 70));

        int result = UC10.totalSeats(bogies);

        assertEquals(222, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UC10.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC10.Bogie("Sleeper", 72));

        UC10.totalSeats(bogies);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}