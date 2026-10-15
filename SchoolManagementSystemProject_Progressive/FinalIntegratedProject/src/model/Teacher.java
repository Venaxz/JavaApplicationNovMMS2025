package model;
import java.math.BigDecimal;
import java.time.LocalDate;
public class Teacher extends Person {
    private String department;
    private BigDecimal monthlySalary;
    public Teacher(String id, String firstName, String lastName, Gender gender, LocalDate dob,
                   String email, String phone, String department, BigDecimal salary) {
        super(id, firstName, lastName, gender, dob, email, phone);
        this.department = department; this.monthlySalary = salary;
    }
    public String getDepartment() { return department; }
    public void setDepartment(String value) { department = value; }
    public BigDecimal getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(BigDecimal value) { if (value == null || value.signum() < 0) throw new IllegalArgumentException("Salary cannot be negative."); monthlySalary = value; }
    @Override public String displayRole() { return "Teacher: " + getFullName() + " - " + department; }
}
