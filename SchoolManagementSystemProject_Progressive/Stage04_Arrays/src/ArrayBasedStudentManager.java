import java.util.Arrays; import java.util.Scanner;
public class ArrayBasedStudentManager {
 public static void main(String[] args){ Scanner in=new Scanner(System.in); System.out.print("Number of students (1-50): "); int n=Integer.parseInt(in.nextLine()); if(n<1||n>50){System.out.println("Enter 1 to 50.");in.close();return;} String[] names=new String[n]; double[] scores=new double[n]; double[][] courseScores=new double[n][2];
 for(int i=0;i<n;i++){System.out.print("Student "+(i+1)+" name: ");names[i]=in.nextLine();System.out.print("Score: ");scores[i]=Double.parseDouble(in.nextLine());courseScores[i][0]=scores[i];courseScores[i][1]=100-scores[i];}
 System.out.println("\nStudents:");for(int i=0;i<n;i++)System.out.println(names[i]+" - "+scores[i]);
 System.out.print("Search name: ");String target=in.nextLine();int found=-1;for(int i=0;i<n;i++)if(names[i].equalsIgnoreCase(target)){found=i;break;}System.out.println(found>=0?"Found: "+names[found]+" score "+scores[found]:"Not found");
 double sum=0;int hi=0,lo=0;for(int i=0;i<n;i++){sum+=scores[i];if(scores[i]>scores[hi])hi=i;if(scores[i]<scores[lo])lo=i;}System.out.println("Highest: "+names[hi]+" ("+scores[hi]+")");System.out.println("Lowest: "+names[lo]+" ("+scores[lo]+")");System.out.println("Average: "+sum/n);Arrays.sort(scores);System.out.println("Sorted scores: "+Arrays.toString(scores));System.out.println("Multidimensional array sample: "+courseScores[0][0]+", "+courseScores[0][1]);in.close(); }
}
