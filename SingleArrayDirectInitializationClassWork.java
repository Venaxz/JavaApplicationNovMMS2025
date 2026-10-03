// a program to store 10 elements in an array and display the count of all the even numbers and of all the odd numbers
public class SingleArrayDirectInitializationClassWork{
    public static void main(String[] args) {

        int[] numbers = {2, 7, 4, 9, 10, 5, 6, 1, 8, 3};
        int countEvenNumbers = 0;
        int countOddNumbers = 0;

        for (int i = 0; i < 10; i++) {
            if (numbers[i] % 2 == 0)
                countEvenNumbers++;
            else
                countOddNumbers++;
        }

        System.out.println("Even numbers = " + countEvenNumbers);
        System.out.println("Odd numbers = " + countOddNumbers);
    }
}