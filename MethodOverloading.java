import java.util.Scanner;


public class MethodOverLoading{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		MethodOverLoading mol = new MethodOverLoading();
		
		System.out.println("Calculating the perimeter of different shapes");
		System.out.println("Enter 1: for square");
		System.out.println("Enter 2: for rectangle");
		System.out.println("Enter 3: for circle");
		System.out.println("Enter 4: for trapezium");
		System.out.println("Enter 5: To Exit");
		System.out.println("**************************");
        System.out.println("");
		
		System.out.printf("Enter your choice: ");
		int choice = scan.nextInt();
		
		switch(choice){
			case 1:
			        System.out.println("You want to calculate the perimeter of a square");
			
			        System.out.print("Please enter the length of the square: ");
			        int lengthOfSquare = scan.nextInt();
			
			        System.out.printf("The perimeter of the square is %d%n", mol.perimeter(lengthOfSquare));
			break;
			
			case 2:
			        System.out.println("You want to calculate the perimeter of a rectangle");
			
			        System.out.print("Please enter the length of the rectangle: ");
			        int lengthOfRect = scan.nextInt();
					
					System.out.print("Please enter the breadth of the rectangle: ");
			        int breadthOfRect = scan.nextInt();
			
			
			        System.out.printf("The perimeter of the rectangle is %d%n", mol.perimeter(lengthOfRect));
			break;
			
			case 3:
		           System.out.println("You want to calculate the perimeter of a circle");
			
			        System.out.print("Please enter the radius of the circle: ");
			        double radius = scan.nextDouble();
			
			        System.out.printf("The perimeter of the circle is %f%n", mol.perimeter(radius));
			break;
			
			case 4:
			       System.out.println("You want to calculate the perimeter of a trapezium");
			
			        System.out.print("Please enter the side1 of the trapezium: ");
			        int side1 = scan.nextInt();
					
					System.out.print("Please enter the side2 of the trapezium: ");
			        int side2 = scan.nextInt();
					
					System.out.print("Please enter the side3 of the trapezium: ");
			        int side3 = scan.nextInt();
					
					System.out.print("Please enter the side4 of the trapezium: ");
			        int side4 = scan.nextInt();
			
			        System.out.printf("The perimeter of the trapezium is %d%n", mol.perimeter(side1,side2,side3,side4 ));
			break;
			default:
		            System.out.println("Program exited, Bye for now.......");
	}
}
	
	public int perimeter(int length){
		int per = 4*length;
		return per;
	}
	
	public int perimeter(int length, int breadth){
		int per = 2*(length + breadth);
		return per;	
	}
	
	public double perimeter(double radius){
		double per = 2*Math.PI*radius;
		return per;
	}
	
	
	public int perimeter(int side1, int side2, int side3, int side4){
		int per = (side1 + side2 + side3 + side4);
		return per;
	}
} 