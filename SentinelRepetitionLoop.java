import java.util.Scanner;

public class SentinelRepetitionLoop{
    public static void  main (String [] args){
	Scanner input = new Scanner(System.in);
	
	int number ; 
	int sum= 0;
	
	while(true) {
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		if (number == -1) {
            break;
		}
        sum += number;
	
	}
	
	System.out.printf("The sum of all the number is %d%n",sum);
	
	
	
}
}
