public class LocalVariable{
	public static void main(String[] args){
		int age = 25;
		
		if(age >= 18){
			int myAge = 30;
			System.out.printf("Miss Mercy is %d years old%n",myAge);	
		}
		
		System.out.printf("Your age is %d%n",age);
	}
}