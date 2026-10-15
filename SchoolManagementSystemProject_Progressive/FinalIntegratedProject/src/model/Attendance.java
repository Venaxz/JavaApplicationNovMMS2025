package model;
import java.time.LocalDate;
public class Attendance {
    private final String studentId;
    private final LocalDate date;
    private final boolean present;
    public Attendance(String studentId, LocalDate date, boolean present) { this.studentId=studentId; this.date=date; this.present=present; }
    public String getStudentId() { return studentId; }
    public LocalDate getDate() { return date; }
    public boolean isPresent() { return present; }
}
