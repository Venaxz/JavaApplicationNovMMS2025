package service;
import model.Student;
import model.StudentLevel;
import repository.StudentRepository;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class StudentQueryService {
    private final StudentRepository repository;
    public StudentQueryService(StudentRepository repository) { this.repository=repository; }
    public long countStudents() { return repository.findAll().stream().count(); }
    public List<Student> sortedByName() { return repository.findAll().stream().sorted(Comparator.comparing(Student::getFullName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList()); }
    public List<Student> namesStartingWith(String prefix) {
        Predicate<Student> starts = s -> s.getFullName().toLowerCase().startsWith(prefix.toLowerCase());
        return repository.findAll().stream().filter(starts).collect(Collectors.toList());
    }
    public List<Student> gpaAbove(double gpa) { return repository.findAll().stream().filter(s -> s.getGpa() > gpa).collect(Collectors.toList()); }
    public Map<String, List<Student>> groupByDepartment() { return repository.findAll().stream().collect(Collectors.groupingBy(Student::getDepartment)); }
    public Map<StudentLevel, List<Student>> groupByLevel() { return repository.findAll().stream().collect(Collectors.groupingBy(Student::getLevel)); }
    public Optional<Student> highestGpa() { return repository.findAll().stream().max(Comparator.comparingDouble(Student::getGpa)); }
    public double averageGpa() { return repository.findAll().stream().mapToDouble(Student::getGpa).average().orElse(0.0); }
}
