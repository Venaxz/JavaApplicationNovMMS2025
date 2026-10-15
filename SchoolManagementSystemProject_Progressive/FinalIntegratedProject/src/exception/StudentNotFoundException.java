package exception;
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) { super("No student found with ID: " + id); }
}
