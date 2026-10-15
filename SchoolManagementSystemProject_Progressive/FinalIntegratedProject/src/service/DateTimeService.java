package service;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class DateTimeService {
    public int age(LocalDate dob) { return Period.between(dob, LocalDate.now()).getYears(); }
    public long daysUntil(LocalDate date) { return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), date); }
    public String format(LocalDate date) { return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy")); }
    public Duration elapsed(LocalDateTime start, LocalDateTime end) { return Duration.between(start,end); }
}
