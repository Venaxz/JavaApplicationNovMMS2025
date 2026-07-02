import java.util.Scanner;

public class MultipleSwitchCaseStatement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your fullName: ");
		String fullName = input.nextLine() ;
		
		System.out.print("Enter your mark: ");
		int mark = input.nextInt() ;
		
		switch(mark/10){
			case 0:
			case 1:
			case 3:
			        System.out.println("=============\n");
					System.out.printf("Student Name: %s%n",fullName);
			        System.out.printf("Student Mark: %d%n",mark);
			        System.out.println("Student Grade: E");
			        System.out.println("=============\n\n");
			break;
			
			case 4:
			        System.out.println("=============\n");
					System.out.printf("Student Name: %s%n",fullName);
			        System.out.printf("Student Mark: %d%n",mark);
			        System.out.println("Student Grade: D");
			        System.out.println("=============\n\n");
			
			break;
			
			case 5:
			        System.out.println("=============\n");
					System.out.printf("Student Name: %s%n",fullName);
			        System.out.printf("Student Mark: %d%n",mark);
			        System.out.println("Student Grade: C");
			        System.out.println("=============\n\n");
			break;
			
			case 6:
			        System.out.println("=============\n");
					System.out.printf("Student Name: %s%n",fullName);
			        System.out.printf("Student Mark: %d%n",mark);
			        System.out.println("Student Grade: B");
			        System.out.println("=============\n\n");
			case 7:
			case 8:
			case 9:
			case 10:
			         System.out.println("=============\n");
					 System.out.printf("Student Name: %s%n",fullName);
			         System.out.printf("Student Mark: %d%n",mark);
			         System.out.println("Student Grade: A");
			         System.out.println("=============\n\n");
			break;
			default:
			         System.out.println("Invalid Input");

		}
	}
}