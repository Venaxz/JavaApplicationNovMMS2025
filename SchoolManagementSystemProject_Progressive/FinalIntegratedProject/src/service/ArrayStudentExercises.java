package service;
/** Array-based exercises retained to demonstrate the earlier stage before collections. */
public class ArrayStudentExercises {
    public static double average(double[] scores) { if (scores.length==0) return 0; double sum=0; for(double score:scores) sum+=score; return sum/scores.length; }
    public static double highest(double[] scores) { if(scores.length==0) throw new IllegalArgumentException("Empty array"); double high=scores[0]; for(double s:scores) if(s>high) high=s; return high; }
    public static double lowest(double[] scores) { if(scores.length==0) throw new IllegalArgumentException("Empty array"); double low=scores[0]; for(double s:scores) if(s<low) low=s; return low; }
    public static void bubbleSort(double[] values) { for(int i=0;i<values.length-1;i++) for(int j=0;j<values.length-1-i;j++) if(values[j]>values[j+1]) { double t=values[j]; values[j]=values[j+1]; values[j+1]=t; } }
}
