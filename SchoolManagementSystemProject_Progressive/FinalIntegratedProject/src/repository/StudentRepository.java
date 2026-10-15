package repository;
import api.Searchable;
import model.Student;
import exception.StudentNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
public class StudentRepository implements Searchable<Student, String> {
    private final TextFileStore store = new TextFileStore("students.txt");
    private final Map<String, Student> students = new LinkedHashMap<>();
    public StudentRepository() {
        for (String line : store.readAll()) {
            if (line.isBlank()) continue;
            try { Student s = Student.fromDataLine(line); students.put(s.getId(), s); }
            catch (RuntimeException ex) { System.err.println("Skipping malformed student record: " + ex.getMessage()); }
        }
    }
    public synchronized Student add(Student student) {
        if (students.containsKey(student.getId())) throw new IllegalArgumentException("A student with this ID already exists.");
        students.put(student.getId(), student); persist(); return student;
    }
    @Override public synchronized Optional<Student> findById(String id) { return Optional.ofNullable(students.get(id)); }
    public synchronized Student requireById(String id) { return findById(id).orElseThrow(() -> new StudentNotFoundException(id)); }
    public synchronized List<Student> findAll() { return new ArrayList<>(students.values()); }
    public synchronized void update(Student student) { if (!students.containsKey(student.getId())) throw new StudentNotFoundException(student.getId()); students.put(student.getId(), student); persist(); }
    public synchronized boolean delete(String id) { boolean removed = students.remove(id) != null; if (removed) persist(); return removed; }
    private void persist() { store.writeAll(students.values().stream().map(Student::toDataLine).collect(Collectors.toList())); }
}
