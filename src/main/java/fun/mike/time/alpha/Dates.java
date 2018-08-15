package fun.mike.time.alpha;

import java.util.Calendar;
import java.util.Date;

public class Dates {
    public static boolean sameDay(Date a, Date b) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(a);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(b);
        boolean sameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
        boolean sameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
        boolean sameDay = calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
        return (sameDay && sameMonth && sameYear);
    }
}
