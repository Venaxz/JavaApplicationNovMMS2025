import java.util.Scanner;

public class AcceptNumbersClasswork {

    public static void main(String[] args) {
        acceptNumbers();
    }

    public static void acceptNumbers() {
        Scanner input = new Scanner(System.in);

        int number;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter number " + i + ": ");
            number = input.nextInt();

            // Sum of 6th to 9th numbers
            if (i >= 6 && i <= 9) {
                sum1 += number;
            }

            // Sum of 2nd, 4th and 9th numbers
            if (i == 2 || i == 4 || i == 9) {
                sum2 += number;
            }

            // Sum of 2nd to 5th numbers
            if (i >= 2 && i <= 5) {
                sum3 += number;
            }
        }

        double result = (double)(sum1 + sum2) / sum3;

        System.out.printf("Result = %.2f%n", result);
    }
}