package fun.mike.time.alpha;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFactory {
    public static Date today() {
        return new Date();
    }

    public static Date dateOf(int year, int month, int day) {
        return dateOf(TimeZone.getDefault(), year, month, day);
    }

    public static Date dateOf(String timeZone, int year, int month, int day) {
        return dateOf(TimeZone.getTimeZone(timeZone), year, month, day);
    }

    public static Date dateOf(TimeZone timeZone, int year, int month, int day) {
        return dateOf(timeZone, year, month, day, 0, 0, 0);
    }

    public static Date midnightOf(int year, int month, int day) {
        return midnightOf(TimeZone.getDefault(), year, month, day);
    }

    public static Date midnightOf(String timeZone, int year, int month, int day) {
        return midnightOf(TimeZone.getTimeZone(timeZone), year, month, day);
    }

    public static Date midnightOf(TimeZone timeZone, int year, int month, int day) {
        return dateOf(timeZone, year, month, day, 23, 59, 59, 0);
    }

    public static Date dateOf(int year, int month, int day, int hour, int minute, int second) {
        return dateOf(TimeZone.getDefault(), year, month, day, hour, minute, second, 0);
    }

    public static Date dateOf(String timeZone, int year, int month, int day, int hour, int minute, int second) {
        return dateOf(TimeZone.getTimeZone(timeZone), year, month, day, hour, minute, second, 0);
    }

    public static Date dateOf(TimeZone timeZone, int year, int month, int day, int hour, int minute, int second) {
        return dateOf(timeZone, year, month, day, hour, minute, second, 0);
    }

    public static Date dateOf(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        return dateOf(TimeZone.getDefault(), year, month, day, hour, minute, second, millisecond);
    }

    public static Date dateOf(String timeZone, int year, int month, int day, int hour, int minute, int second, int millisecond) {
        return dateOf(TimeZone.getTimeZone(timeZone), year, month, day, hour, minute, second, millisecond);
    }

    public static Date dateOf(TimeZone timeZone, int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(year, month, day, hour, minute, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }
}
