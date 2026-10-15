import java.util.Scanner;
public class StudentResultProcessor {
    public static String grade(double average) { if(average>=70)return "A"; if(average>=60)return "B"; if(average>=50)return "C"; if(average>=45)return "D"; return "F"; }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in); int count;
        do { System.out.print("Number of courses (1-20): "); count=Integer.parseInt(in.nextLine()); } while(count<1 || count>20);
        double total=0, high=-1, low=101; int passed=0, failed=0;
        for(int i=1;i<=count;i++) { System.out.print("Score for course "+i+" (enter -1 to skip): "); double score=Double.parseDouble(in.nextLine()); if(score==-1) continue; if(score<0||score>100){System.out.println("Invalid score skipped."); continue;} total+=score; if(score>high)high=score; if(score<low)low=score; if(score>=45)passed++;else failed++; }
        int recorded=passed+failed; if(recorded==0){System.out.println("No valid scores entered.");} else {double avg=total/recorded; System.out.println("Total: "+total+"\nAverage: "+avg+"\nHighest: "+high+"\nLowest: "+low+"\nGrade: "+grade(avg)+"\nPassed: "+passed+"\nFailed: "+failed);}
        int n=1; while(n<=2){System.out.println("Result report section "+n); n++;} // while demonstration
        for(int row=1;row<=2;row++){for(int col=1;col<=3;col++)System.out.print("* ");System.out.println();} // nested loops
        in.close();
    }
}
