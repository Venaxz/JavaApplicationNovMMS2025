import java.util.Scanner;

public class WhileLoopClassWork{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int num;
		int sum = 0;
		int average = 0;
		int product = 1;
		int i = 1;
		
		while(i <= 10){
			System.out.print("Enter number: ");
			num = scan.nextInt();
			
			sum += num;
			product *= num;
			i++;

			
		}
		average = sum / 10;
		System.out.println("The sum of the number is " +sum);
		System.out.println("The average of the number is " + average);
        System.out.println("The product of the number is " + product);

		
	}
}