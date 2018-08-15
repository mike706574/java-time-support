package fun.mike.time.alpha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import static fun.mike.time.alpha.DateFactory.dateOf;
import static fun.mike.time.alpha.DateFactory.midnightOf;
import static org.junit.Assert.assertEquals;

public class DateFactoryTest {
    @Test
    public void building() {
        assertEquals(toDate("01/01/1995 00:00:00"), dateOf(1995, 0, 1));
        assertEquals(toDate("01/01/1995 01:00:00"), dateOf(1995, 0, 1, 1, 0, 0));
        assertEquals(toDate("01/01/1995 01:00:00"), dateOf(1995, 0, 1, 1, 0, 0, 0));

        assertEquals(toDate("31/12/1994 18:00:00"), dateOf("UTC", 1995, 0, 1));
        assertEquals(toDate("31/12/1994 19:00:00"), dateOf("UTC", 1995, 0, 1, 1, 0, 0));
        assertEquals(toDate("31/12/1994 19:00:00"), dateOf("UTC", 1995, 0, 1, 1, 0, 0, 0));

        assertEquals(toDate("31/12/1994 18:00:00"), dateOf(TimeZone.getTimeZone("UTC"), 1995, 0, 1));
        assertEquals(toDate("31/12/1994 19:00:00"), dateOf(TimeZone.getTimeZone("UTC"), 1995, 0, 1, 1, 0, 0));
        assertEquals(toDate("31/12/1994 19:00:00"), dateOf(TimeZone.getTimeZone("UTC"), 1995, 0, 1, 1, 0, 0, 0));

        assertEquals(toDate("01/01/1995 23:59:59"), midnightOf(1995, 0, 1));
        assertEquals(toDate("01/01/1995 17:59:59"), midnightOf("UTC", 1995, 0, 1));
        assertEquals(toDate("01/01/1995 17:59:59"), midnightOf(TimeZone.getTimeZone("UTC"), 1995, 0, 1));
    }

    private static Date toDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
