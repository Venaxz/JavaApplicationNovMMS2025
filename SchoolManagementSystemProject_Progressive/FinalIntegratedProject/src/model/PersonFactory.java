package model;
import java.time.LocalDate;
public final class PersonFactory {
    private PersonFactory() {}
    public static Person create(String role, String id, String first, String last, Gender gender, LocalDate dob, String email, String phone) {
        return switch (role.trim().toUpperCase()) {
            case "ADMIN" -> new Administrator(id, first, last, gender, dob, email, phone);
            case "STUDENT" -> new Student(id, first, last, gender, dob, email, phone, "General", StudentLevel.LEVEL_100);
            default -> throw new IllegalArgumentException("Factory supports ADMIN and STUDENT demo types.");
        };
    }
}
