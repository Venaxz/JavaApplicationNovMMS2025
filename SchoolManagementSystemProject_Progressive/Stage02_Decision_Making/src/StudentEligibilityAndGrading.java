import java.util.Scanner;
public class StudentEligibilityAndGrading {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Student age: "); int age = Integer.parseInt(in.nextLine());
        System.out.print("Student level (100, 200, 300, 400): "); int level = Integer.parseInt(in.nextLine());
        System.out.print("Course score (0-100): "); int score = Integer.parseInt(in.nextLine());
        boolean eligible = age >= 16 && (level == 100 || level == 200 || level == 300 || level == 400);
        String grade;
        if (score < 0 || score > 100) grade = "Invalid score";
        else if (score >= 70) grade = "A"; else if (score >= 60) grade = "B";
        else if (score >= 50) grade = "C"; else if (score >= 45) grade = "D"; else grade = "F";
        String levelName;
        switch (level) { case 100: levelName="100 level"; break; case 200: levelName="200 level"; break; case 300: levelName="300 level"; break; case 400: levelName="400 level"; break; default: levelName="Invalid level"; }
        System.out.println("Eligible to register: " + (eligible ? "Yes" : "No"));
        if (age >= 16) { if (levelName.startsWith("Invalid")) System.out.println("Check the level entered."); else System.out.println("Level accepted: " + levelName); }
        System.out.println("Grade: " + grade); System.out.println("Status: " + (score >= 45 && score <= 100 ? "Pass" : "Fail/Invalid"));
        in.close();
    }
}
