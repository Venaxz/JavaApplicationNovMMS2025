package model;
import api.Printable;
public class Result implements Printable {
    private final String studentId, courseName;
    private final double total, average, highest, lowest;
    private final Grade grade;
    private final int passed, failed;
    public Result(String studentId, String courseName, double total, double average, double highest, double lowest, Grade grade, int passed, int failed) {
        this.studentId=studentId; this.courseName=courseName; this.total=total; this.average=average; this.highest=highest; this.lowest=lowest; this.grade=grade; this.passed=passed; this.failed=failed;
    }
    public Grade getGrade() { return grade; }
    @Override public String printableSummary() { return toString(); }
    @Override public String toString() { return "Result{studentId='"+studentId+"', course='"+courseName+"', total="+total+", average="+String.format("%.2f",average)+", highest="+highest+", lowest="+lowest+", grade="+grade+", passed="+passed+", failed="+failed+"}"; }
}
