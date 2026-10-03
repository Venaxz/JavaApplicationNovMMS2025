public class UsingMathClass{
	public static void main(String[] args){
		int x = -45;
		
		int y = 4;
		int a = 64;
		
		int num1 = 6;
		int num2 = 25;
		
		System.out.println("The absolute number is " +Math.abs(x));
		System.out.println("4 raise to the power of 2 is " +Math.pow(y,2));
		System.out.println("The square root of 64 is " +Math.sqrt(a));
		System.out.println("The maximum between 6 and 25 is " +Math.max(num1,num2));
		System.out.println("The minimum between 6 and 25 is " +Math.min(num1,num2));
		System.out.println("The generated number is "+Math.random());
	}
} 
