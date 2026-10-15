package model;
import java.time.LocalDate;
public class Administrator extends Person {
    public Administrator(String id, String first, String last, Gender gender, LocalDate dob, String email, String phone) {
        super(id, first, last, gender, dob, email, phone);
    }
    @Override public String displayRole() { return "Administrator: " + getFullName(); }
}
