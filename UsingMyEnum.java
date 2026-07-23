public class UsingMyEnum{
	public static void main(String[] args){
		DaysOfWeek day1 = DaysOfWeek.WEDNESDAY;
		DaysOfWeek day2 = DaysOfWeek.THURSDAY;
		
		System.out.printf("Today is %s%n",day1);
		System.out.printf("Tomorrow will be %s%n",day2);
	}
}