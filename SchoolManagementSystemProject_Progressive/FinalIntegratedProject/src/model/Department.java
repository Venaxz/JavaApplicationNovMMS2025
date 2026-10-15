package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Department {
    private final String name;
    private final List<Student> students = new ArrayList<>(); // Aggregation: students may exist independently.
    public Department(String name) { if (name == null || name.isBlank()) throw new IllegalArgumentException("Department name required."); this.name = name.trim(); }
    public String getName() { return name; }
    public void addStudent(Student student) { students.add(java.util.Objects.requireNonNull(student)); }
    public List<Student> getStudents() { return Collections.unmodifiableList(students); }
}
