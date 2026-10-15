import java.util.Scanner;
public class StudentRegistrationMethods {
 static String fullName(String first,String last){return (first+" "+last).trim();}
 static double calculateAverage(double a,double b){return (a+b)/2.0;}
 static double calculateAverage(double a,double b,double c){return (a+b+c)/3.0;} // overloading
 static String calculateGrade(double average){if(average>=70)return "A";if(average>=60)return "B";if(average>=50)return "C";if(average>=45)return "D";return "F";}
 void displayStudent(String id,String name){System.out.println("Student "+id+": "+name);} // instance method
 public static void main(String[] args){Scanner in=new Scanner(System.in);System.out.print("ID: ");String id=in.nextLine();System.out.print("First name: ");String first=in.nextLine();System.out.print("Last name: ");String last=in.nextLine();System.out.print("Score 1: ");double a=Double.parseDouble(in.nextLine());System.out.print("Score 2: ");double b=Double.parseDouble(in.nextLine());String name=fullName(first,last);double avg=calculateAverage(a,b);System.out.println("Average: "+avg+" Grade: "+calculateGrade(avg));new StudentRegistrationMethods().displayStudent(id,name);in.close();}
}
