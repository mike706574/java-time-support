package fun.mike.time.alpha;

import org.junit.Test;

import static fun.mike.time.alpha.DateFactory.dateOf;
import static fun.mike.time.alpha.DateFactory.midnightOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DatesTest {
    @Test
    public void sameDay() {
        assertTrue(Dates.sameDay(dateOf(1995, 0, 1),
                                 midnightOf(1995, 0, 1)));
        assertTrue(Dates.sameDay(dateOf(1995, 0, 1, 1, 0, 0),
                                 dateOf(1995, 0, 1, 2, 0, 0)));
        assertFalse(Dates.sameDay(midnightOf(1995, 0, 1),
                                  dateOf(1995, 0, 2)));
    }
}
