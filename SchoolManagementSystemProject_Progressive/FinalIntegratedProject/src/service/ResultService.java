package service;
import model.*;
import exception.InvalidScoreException;
public class ResultService {
    public Result processResult(String studentId, String course, double... scores) {
        if (scores == null || scores.length == 0) throw new IllegalArgumentException("At least one score is required.");
        double total=0, highest=Double.NEGATIVE_INFINITY, lowest=Double.POSITIVE_INFINITY;
        int passed=0, failed=0;
        for (double score : scores) {
            if (score < 0 || score > 100) throw new InvalidScoreException(score);
            total += score; highest=Math.max(highest,score); lowest=Math.min(lowest,score);
            if (score >= 40) passed++; else failed++;
        }
        double average=total/scores.length;
        return new Result(studentId, course, total, average, highest, lowest, Grade.fromScore(average), passed, failed);
    }
    public double calculateAverage(double... scores) {
        if (scores == null || scores.length == 0) throw new IllegalArgumentException("Scores cannot be empty.");
        double total=0; for (double score:scores) total+=score; return total/scores.length;
    }
}
