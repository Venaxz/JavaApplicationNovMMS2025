import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import model.*;
import repository.StudentRepository;
import service.*;
import util.AppLogger;

/**
 * Application entry point. Keep this filename and class name exactly as required.
 * The other classes are intentionally stored in their own named files/packages.
 */
public class SchoolManagementSystemProject {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final StudentService STUDENT_SERVICE = new StudentService(STUDENT_REPOSITORY);
    private static final ResultService RESULT_SERVICE = new ResultService();
    private static final PaymentService PAYMENT_SERVICE = new PaymentService();
    private static final StudentQueryService QUERY_SERVICE = new StudentQueryService(STUDENT_REPOSITORY);

    public static void main(String[] args) {
        AppLogger.info("School Management System started.");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = INPUT.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> registerStudent();
                    case "2" -> displayStudents();
                    case "3" -> searchStudent();
                    case "4" -> processResult();
                    case "5" -> recordPayment();
                    case "6" -> runReports();
                    case "7" -> new ui.SchoolManagementWindow(STUDENT_SERVICE).showWindow();
                    case "8" -> startRestServer();
                    case "9" -> runNetworkDemo();
                    case "10" -> showConceptDemonstration();
                    case "0" -> running = false;
                    default -> System.out.println("Invalid option. Choose a number shown on the menu.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Input error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Operation could not be completed: " + ex.getMessage());
                AppLogger.error("Operation failed", ex);
            }
        }
        INPUT.close();
        System.out.println("School Management System closed.");
    }

    private static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("       SCHOOL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Register student");
        System.out.println("2. Display all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Process a course result");
        System.out.println("5. Record student payment");
        System.out.println("6. Reports and student queries");
        System.out.println("7. Open basic Swing window");
        System.out.println("8. Start educational REST server");
        System.out.println("9. Run socket networking demo");
        System.out.println("10. Demonstrate OOP/polymorphism");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private static void registerStudent() {
        System.out.println("\n--- Student Registration ---");
        System.out.print("Student ID: "); String id = INPUT.nextLine().trim();
        System.out.print("First name: "); String first = INPUT.nextLine().trim();
        System.out.print("Last name: "); String last = INPUT.nextLine().trim();
        System.out.print("Gender (MALE/FEMALE/OTHER): ");
        Gender gender = Gender.valueOf(INPUT.nextLine().trim().toUpperCase());
        System.out.print("Date of birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(INPUT.nextLine().trim());
        System.out.print("Email: "); String email = INPUT.nextLine().trim();
        System.out.print("Phone number: "); String phone = INPUT.nextLine().trim();
        System.out.print("Department: "); String department = INPUT.nextLine().trim();
        System.out.print("Level (ND1/ND2/HND1/HND2/100/200/300/400): ");
        StudentLevel level = StudentLevel.fromInput(INPUT.nextLine().trim());
        Student student = STUDENT_SERVICE.registerStudent(id, first, last, gender, dob,
                email, phone, department, level);
        System.out.println("\nStudent registered successfully.");
        System.out.println(student);
        System.out.println("Age: " + student.getAge());
        System.out.println("Full name: " + student.getFullName());
        System.out.println("Registration status: " + student.getStatus());
    }

    private static void displayStudents() {
        List<Student> students = STUDENT_SERVICE.getAllStudents();
        if (students.isEmpty()) { System.out.println("No students have been registered."); return; }
        System.out.println("\n--- Registered Students ---");
        students.forEach(System.out::println);
    }

    private static void searchStudent() {
        System.out.print("Enter student ID: ");
        Student student = STUDENT_SERVICE.searchStudent(INPUT.nextLine().trim());
        System.out.println(student);
    }

    private static void processResult() {
        System.out.print("Student ID: "); String studentId = INPUT.nextLine().trim();
        STUDENT_SERVICE.searchStudent(studentId);
        System.out.print("Course name: "); String course = INPUT.nextLine().trim();
        System.out.print("Number of assessment items: ");
        int count = Integer.parseInt(INPUT.nextLine().trim());
        if (count < 1 || count > 20) throw new IllegalArgumentException("Enter between 1 and 20 scores.");
        double[] scores = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Score " + (i + 1) + " (0-100): ");
            scores[i] = Double.parseDouble(INPUT.nextLine().trim());
        }
        Result result = RESULT_SERVICE.processResult(studentId, course, scores);
        System.out.println(result);
    }

    private static void recordPayment() {
        System.out.print("Student ID: "); String studentId = INPUT.nextLine().trim();
        STUDENT_SERVICE.searchStudent(studentId);
        System.out.print("Amount: "); BigDecimal amount = new BigDecimal(INPUT.nextLine().trim());
        System.out.print("Method (CASH/BANK_TRANSFER/CARD): ");
        PaymentMethod method = PaymentMethod.valueOf(INPUT.nextLine().trim().toUpperCase());
        Payment payment = PAYMENT_SERVICE.recordPayment(studentId, amount, method);
        System.out.println("Payment recorded: " + payment);
    }

    private static void runReports() {
        System.out.println("\n--- Reports ---");
        System.out.println("Student count: " + QUERY_SERVICE.countStudents());
        System.out.println("Students by department: " + QUERY_SERVICE.groupByDepartment());
        System.out.println("Students by level: " + QUERY_SERVICE.groupByLevel());
        System.out.println("Sort by name:");
        QUERY_SERVICE.sortedByName().forEach(System.out::println);
        System.out.print("Search names starting with (leave blank to skip): ");
        String prefix = INPUT.nextLine().trim();
        if (!prefix.isEmpty()) QUERY_SERVICE.namesStartingWith(prefix).forEach(System.out::println);
    }

    private static void startRestServer() throws Exception {
        api.SchoolRestServer server = new api.SchoolRestServer(STUDENT_SERVICE);
        server.start();
        System.out.println("REST server started on http://localhost:8080/students");
        System.out.println("Keep this application open while testing the endpoint.");
    }

    private static void runNetworkDemo() throws Exception {
        Thread server = new Thread(() -> {
            try { new network.SchoolSocketServer(5050).startOnce(); }
            catch (Exception e) { AppLogger.error("Socket server error", e); }
        });
        server.setDaemon(true);
        server.start();
        Thread.sleep(250);
        System.out.println("Socket server started on port 5050.");
        System.out.println("Client response: " + network.SchoolSocketClient.request("localhost", 5050, "HELLO SCHOOL"));
    }

    private static void showConceptDemonstration() {
        System.out.println("\n--- Inheritance and Runtime Polymorphism ---");
        Person student = new Student("DEMO-001", "Ada", "Okafor", Gender.FEMALE,
                LocalDate.of(2004, 4, 12), "ada@example.com", "08000000000",
                "Computer Science", StudentLevel.ND1);
        Person teacher = new Teacher("T-001", "Chidi", "Bello", Gender.MALE,
                LocalDate.of(1985, 1, 1), "chidi@example.com", "08000000001", "Computing", new BigDecimal("250000"));
        System.out.println(student.displayRole());
        System.out.println(teacher.displayRole());
        System.out.println("Same parent type, different implementations (dynamic dispatch).");
    }
}
