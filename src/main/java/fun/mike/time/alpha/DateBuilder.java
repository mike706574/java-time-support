package fun.mike.time.alpha;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;

public class DateBuilder {
    private final Date originalDate;
    private Date modifiedDate;

    public DateBuilder(Date originalDate) {
        this.originalDate = originalDate;
        this.modifiedDate = new Date(originalDate.getTime());
    }

    public DateBuilder withTime(int hour, int minute, int second) {
        return withHour(hour).withMinute(minute).withSecond(second);
    }

    public DateBuilder withTime(int hour, int minute, int second, int millisecond) {
        return withTime(hour, minute, second).withMillisecond(millisecond);
    }

    public DateBuilder withDay(int year, int month, int day) {
        return withYear(year).withMonth(month).withDay(day);
    }

    public DateBuilder withHour(int hour) {
        return mutate(cal -> cal.set(Calendar.HOUR, hour));
    }

    public DateBuilder withMinute(int minute) {
        return mutate(cal -> cal.set(Calendar.MINUTE, minute));
    }

    public DateBuilder withSecond(int second) {
        return mutate(cal -> cal.set(Calendar.SECOND, second));
    }

    public DateBuilder withMillisecond(int millisecond) {
        return mutate(cal -> cal.set(Calendar.MILLISECOND, millisecond));
    }

    public DateBuilder withDay(int day) {
        return mutate(cal -> cal.set(Calendar.DAY_OF_MONTH, day));
    }

    public DateBuilder withYear(int year) {
        return mutate(cal -> cal.set(Calendar.YEAR, year));
    }

    public DateBuilder withMonth(int month) {
        return mutate(cal -> cal.set(Calendar.MONTH, month));
    }

    private final DateBuilder mutate(Consumer<Calendar> consumer) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(modifiedDate);
        consumer.accept(calendar);
        modifiedDate = calendar.getTime();
        return this;
    }

    public Date build() {
        return new Date(modifiedDate.getTime());
    }
}
