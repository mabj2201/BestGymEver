import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BestGymEverTest {
    BestGymEver bestGymEver = new BestGymEver();
    String line = "9710014342, Marica Björklund";


    @Test
    void getPersonNr() {
      assert(bestGymEver.getPersonNr(line).equals("9710014342"));
      assert!(bestGymEver.getPersonNr(line).equals("5685636745745"));
      assert!(bestGymEver.getPersonNr(line).equals("Marica Björklund"));
    }

    @Test
    void getName() {
        assert(bestGymEver.getName(line).equals("Marica Björklund"));
        assert!(bestGymEver.getName(line).equals("Annagreta"));
        assert!(bestGymEver.getName(line)).equals("9710014342");
    }

    @Test
    void yearCard() {
        LocalDate dateTest = LocalDate.now().minusMonths(11);
        LocalDate dateTest2 = LocalDate.now().minusMonths(16);
        assertTrue(bestGymEver.yearCard(String.valueOf(dateTest)));
        assertFalse(bestGymEver.yearCard(String.valueOf(dateTest2)));
    }

}