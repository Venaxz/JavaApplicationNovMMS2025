package model;
import api.Payable;
import api.Printable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
public class Student extends Person implements Payable, Printable, Comparable<Student>, java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private final String department;
    private StudentLevel level;
    private StudentStatus status = StudentStatus.REGISTERED;
    private double gpa;
    public Student(String id, String firstName, String lastName, Gender gender, LocalDate dob,
                   String email, String phone, String department, StudentLevel level) {
        super(id, firstName, lastName, gender, dob, email, phone);
        if (getAge() < 16) throw new IllegalArgumentException("A student must be at least 16 years old.");
        this.department = Objects.requireNonNull(department).trim();
        if (this.department.isEmpty()) throw new IllegalArgumentException("Department is required.");
        this.level = Objects.requireNonNull(level);
    }
    public String getDepartment() { return department; }
    public StudentLevel getLevel() { return level; }
    public void setLevel(StudentLevel level) { this.level = Objects.requireNonNull(level); }
    public StudentStatus getStatus() { return status; }
    public void setStatus(StudentStatus status) { this.status = Objects.requireNonNull(status); }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { if (gpa < 0 || gpa > 5) throw new IllegalArgumentException("GPA must be between 0 and 5."); this.gpa = gpa; }
    @Override public String displayRole() { return "Student: " + getFullName() + " (" + getId() + ")"; }
    @Override public BigDecimal calculatePayment() { return BigDecimal.ZERO; }
    @Override public String printableSummary() { return toString(); }
    @Override public int compareTo(Student other) { return getId().compareToIgnoreCase(other.getId()); }
    public String toDataLine() {
        return String.join("|", safe(getId()), safe(getFirstName()), safe(getLastName()), getGender().name(),
            getDateOfBirth().toString(), safe(getEmail()), safe(getPhone()), safe(department), level.name(),
            status.name(), Double.toString(gpa));
    }
    private static String safe(String value) { return value.replace("|", " ").replace("\n", " "); }
    public static Student fromDataLine(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 11) throw new IllegalArgumentException("Invalid student record.");
        Student s = new Student(p[0], p[1], p[2], Gender.valueOf(p[3]), LocalDate.parse(p[4]),
            p[5], p[6], p[7], StudentLevel.valueOf(p[8]));
        s.setStatus(StudentStatus.valueOf(p[9])); s.setGpa(Double.parseDouble(p[10])); return s;
    }
    @Override public String toString() {
        return "ID: " + getId() + " | Name: " + getFullName() + " | Gender: " + getGender()
            + " | DOB: " + getDateOfBirth() + " | Age: " + getAge() + " | Email: " + getEmail()
            + " | Phone: " + getPhone() + " | Department: " + department + " | Level: " + level
            + " | Status: " + status + " | GPA: " + gpa;
    }
}
