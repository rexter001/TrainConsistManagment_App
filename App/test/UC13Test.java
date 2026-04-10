import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UC13Test {

    @Test
    void testLoopFilteringLogic() {
        List<UC13.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC13.Bogie("Sleeper", 72));
        bogies.add(new UC13.Bogie("AC Chair", 56));

        List<UC13.Bogie> result = UC13.loopFilter(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<UC13.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC13.Bogie("Sleeper", 72));
        bogies.add(new UC13.Bogie("AC Chair", 56));

        List<UC13.Bogie> result = UC13.streamFilter(bogies);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UC13.Bogie> bogies = new ArrayList<>();
        bogies.add(new UC13.Bogie("Sleeper", 72));
        bogies.add(new UC13.Bogie("AC Chair", 56));
        bogies.add(new UC13.Bogie("General", 90));

        assertEquals(
                UC13.loopFilter(bogies).size(),
                UC13.streamFilter(bogies).size()
        );
    }

    @Test
    void testExecutionTimeMeasurement() {
        long time = UC13.measureExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                Math.sqrt(i);
            }
        });

        assertTrue(time > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<UC13.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new UC13.Bogie("Sleeper", 72));
        }

        List<UC13.Bogie> result = UC13.streamFilter(bogies);

        assertEquals(10000, result.size());
    }
}