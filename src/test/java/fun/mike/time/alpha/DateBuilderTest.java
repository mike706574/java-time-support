package fun.mike.time.alpha;

import java.util.Date;

import org.junit.Test;

import static fun.mike.time.alpha.DateFactory.dateOf;
import static org.junit.Assert.assertEquals;

public class DateBuilderTest {
    @Test
    public void building() {
        Date date = dateOf(1995, 0, 1, 0, 0, 0, 0);

        assertEquals(dateOf(1996, 0, 1, 0, 0, 0, 0),
                     new DateBuilder(date).withYear(1996).build());

        assertEquals(dateOf(1995, 1, 1, 0, 0, 0, 0),
                     new DateBuilder(date).withMonth(1).build());

        assertEquals(dateOf(1995, 0, 2, 0, 0, 0, 0),
                     new DateBuilder(date).withDay(2).build());

        assertEquals(dateOf(1995, 0, 1, 1, 0, 0, 0),
                     new DateBuilder(date).withHour(1).build());

        assertEquals(dateOf(1995, 0, 1, 0, 1, 0, 0),
                     new DateBuilder(date).withMinute(1).build());

        assertEquals(dateOf(1995, 0, 1, 0, 0, 1, 0),
                     new DateBuilder(date).withSecond(1).build());

        assertEquals(dateOf(1995, 0, 1, 0, 0, 0, 1),
                     new DateBuilder(date).withMillisecond(1).build());

        assertEquals(dateOf(1996, 2, 2, 0, 0, 0, 0),
                     new DateBuilder(date).withDay(1996, 2, 2).build());

        assertEquals(dateOf(1995, 0, 1, 1, 1, 1, 0),
                     new DateBuilder(date).withTime(1, 1, 1).build());

        assertEquals(dateOf(1995, 0, 1, 1, 1, 1, 1),
                     new DateBuilder(date).withTime(1, 1, 1, 1).build());
    }
}
