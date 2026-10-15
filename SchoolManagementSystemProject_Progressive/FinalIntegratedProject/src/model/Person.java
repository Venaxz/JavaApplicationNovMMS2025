package model;
import java.time.LocalDate;
public abstract class Person {
    private final String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    protected Person(String id, String firstName, String lastName, Gender gender,
                     LocalDate dateOfBirth, String email, String phone) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID is required.");
        this.id = id.trim();
        setFirstName(firstName); setLastName(lastName);
        this.gender = java.util.Objects.requireNonNull(gender);
        this.dateOfBirth = java.util.Objects.requireNonNull(dateOfBirth);
        if (dateOfBirth.isAfter(LocalDate.now())) throw new IllegalArgumentException("Date of birth cannot be in the future.");
        this.email = email == null ? "" : email.trim();
        this.phone = phone == null ? "" : phone.trim();
    }
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { if (value == null || value.isBlank()) throw new IllegalArgumentException("First name is required."); firstName = value.trim(); }
    public String getLastName() { return lastName; }
    public void setLastName(String value) { if (value == null || value.isBlank()) throw new IllegalArgumentException("Last name is required."); lastName = value.trim(); }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = java.util.Objects.requireNonNull(gender); }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate date) { if (date == null || date.isAfter(LocalDate.now())) throw new IllegalArgumentException("Invalid date of birth."); dateOfBirth = date; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email == null ? "" : email.trim(); }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone == null ? "" : phone.trim(); }
    public String getFullName() { return firstName + " " + lastName; }
    public int getAge() { return java.time.Period.between(dateOfBirth, LocalDate.now()).getYears(); }
    public abstract String displayRole();
}
