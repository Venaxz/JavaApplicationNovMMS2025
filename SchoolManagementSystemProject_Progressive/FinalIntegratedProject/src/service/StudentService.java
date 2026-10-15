package service;
import model.*;
import repository.StudentRepository;
import util.AppLogger;
import java.time.LocalDate;
import java.util.List;
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) { this.repository = repository; }
    public Student registerStudent(String id, String first, String last, Gender gender, LocalDate dob,
                                   String email, String phone, String department, StudentLevel level) {
        Student student = new Student(id, first, last, gender, dob, email, phone, department, level);
        repository.add(student); AppLogger.info("Student registered: " + id); return student;
    }
    public Student searchStudent(String id) { return repository.requireById(id); }
    public List<Student> getAllStudents() { return repository.findAll(); }
    public boolean deleteStudent(String id) { boolean removed = repository.delete(id); if (removed) AppLogger.info("Student deleted: " + id); return removed; }
    public void updateGpa(String id, double gpa) { Student s=searchStudent(id); s.setGpa(gpa); repository.update(s); }
}
