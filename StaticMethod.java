public class StaticMethod{
	//method
	
	public static void main(String[] args){
		System.out.println(addNumber(8,45,23));
		System.out.println(addNumber(100,500));
		System.out.println(addNumber(50,900));
		System.out.println(addNumber(100,500,8));
		System.out.println(addNumber(10,50));
		System.out.println(addNumber(70,50,30));
		System.out.println(addNumber(100,300));
		System.out.println(addNumber(200,100,300));
		System.out.println(addNumber(90,75));
		System.out.println(addNumber(55,37,71));
		System.out.println(addNumber(157,111));
		System.out.println(addNumber(93,51,73));
		System.out.println(addNumber(30,50));

	}
	
	//method
	public static int addNumber(int num1,int num2,int num3){
		int addition = num1 + num2 + num3;
		
		return addition;
	}
	
	public static int addNumber(int num1,int num2){
		int addition = num1 + num2;
		
		return addition;
		
	}

}