public class OperatorPart2{
	public static void main(String[] args){
		int num1 = 15;
		int num2 = 30;
		int num3 = 50;
		
		boolean isGreater = (num1 > num2) && (num1 > num3);
		
	System.out.printf(" (%d > %d) && (%d > %d) = %b%n",num1,num2,num1,num3,isGreater);
	}
}