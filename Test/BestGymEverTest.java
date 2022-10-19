import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BestGymEverTest {
    BestGymEver bestGymEver = new BestGymEver();
    String line = "9703118697, Supersnälla Silversara";


    @Test
    void getPersonNr() {
      assert(bestGymEver.getPersonNr(line).equals("9703118697"));
      assert!(bestGymEver.getPersonNr(line).equals("5685636745745"));
      assert!(bestGymEver.getPersonNr(line).equals("Supersnälla Silversara"));
    }

    @Test
    void getName() {
        assert(bestGymEver.getName(line).equals("Supersnälla Silversara"));
        assert!(bestGymEver.getName(line).equals("Stålhenrik"));
        assert!(bestGymEver.getName(line)).equals("9703118697");
    }

    @Test
    void yearCard() {
        LocalDate dateTest = LocalDate.now().minusMonths(11);
        LocalDate dateTest2 = LocalDate.now().minusMonths(16);
        assertTrue(bestGymEver.yearCard(String.valueOf(dateTest)));
        assertFalse(bestGymEver.yearCard(String.valueOf(dateTest2)));
    }

}