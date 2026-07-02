public class TestMe{
	public static void main(String[] args){
		InstanceMethod test = new InstanceMethod();
		
		System.out.println(test.addNumber(30,90,40));
		System.out.println(StaticMethod.addNumber(90,60,40));
	}
}