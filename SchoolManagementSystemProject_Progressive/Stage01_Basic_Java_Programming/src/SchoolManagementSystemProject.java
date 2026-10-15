import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SchoolManagementSystemProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== SCHOOL MANAGEMENT SYSTEM: STUDENT REGISTRATION ===");
        System.out.print("Student ID: "); String id = input.nextLine().trim();
        System.out.print("First name: "); String first = input.nextLine().trim();
        System.out.print("Last name: "); String last = input.nextLine().trim();
        System.out.print("Gender: "); String gender = input.nextLine().trim();
        System.out.print("Date of birth (YYYY-MM-DD): "); LocalDate dob = LocalDate.parse(input.nextLine().trim());
        System.out.print("Email: "); String email = input.nextLine().trim();
        System.out.print("Phone number: "); String phone = input.nextLine().trim();
        System.out.print("Department: "); String department = input.nextLine().trim();
        System.out.print("Level: "); String level = input.nextLine().trim();
        int age = Period.between(dob, LocalDate.now()).getYears();
        String fullName = (first + " " + last).trim();
        boolean registered = !id.isEmpty() && !first.isEmpty() && !last.isEmpty();
        System.out.println("\n--- Registration Summary ---");
        System.out.println("Student ID: " + id); System.out.println("Full name: " + fullName);
        System.out.println("Gender: " + gender); System.out.println("Date of birth: " + dob);
        System.out.println("Age: " + age); System.out.println("Email: " + email);
        System.out.println("Phone: " + phone); System.out.println("Department: " + department);
        System.out.println("Level: " + level); System.out.println("Registration status: " + (registered ? "Registered" : "Incomplete"));
        input.close();
    }
}
