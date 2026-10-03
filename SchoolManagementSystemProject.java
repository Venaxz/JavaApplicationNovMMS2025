import java.util.Scanner;

public class SchoolManagementSystemProject{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== STUDENT REGISTRATION =====");

        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Gender: ");
        String gender = input.nextLine();

        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
        String dateOfBirth = input.nextLine();

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        System.out.print("Enter Level: ");
        String level = input.nextLine();
		
		

    System.out.println("\n===== STUDENT INFORMATION =====");
    System.out.println("Student ID: " + studentId);
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Gender: " + gender);
    System.out.println("Date of Birth: " + dateOfBirth);
    System.out.println("Email: " + email);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Department: " + department);
    System.out.println("Level: " + level);
	}
} 