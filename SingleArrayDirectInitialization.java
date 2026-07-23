public class SingleArrayDirectInitialization{
	public static void main(String[] args){
		
		//direct initialization
		int[] numbers = {70,90,80,10,40,69,87,59,91,89};
		
		int addition = numbers[8] + numbers[2];
		
		boolean isGreater = numbers[8] > numbers[2];

		
		System.out.printf("Element at index 7 is %d%n",numbers[7]);
		System.out.printf("The sum of the numbers is %d%n",addition);
		System.out.printf("is numbers[8] > numbers[2] = %b%n",isGreater);
	}
}