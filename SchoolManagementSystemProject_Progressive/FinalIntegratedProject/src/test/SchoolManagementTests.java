package test;
import model.*;
import service.ResultService;
import java.time.LocalDate;
/** Dependency-free test runner. Run with -ea; assertions verify positive and negative cases. */
public class SchoolManagementTests {
    public static void main(String[] args) {
        Student student=new Student("T-TEST-1","Test","Student",Gender.OTHER,LocalDate.of(2000,1,1),"test@example.com","000","Testing",StudentLevel.ND1);
        assert student.getFullName().equals("Test Student");
        assert student.getAge() >= 16;
        assert Grade.fromScore(75)==Grade.A;
        assert Grade.fromScore(65)==Grade.B;
        ResultService results=new ResultService();
        Result result=results.processResult("T-TEST-1","Java",80,60,40);
        assert result.getGrade()==Grade.B;
        boolean invalidScore=false;
        try { results.processResult("T-TEST-1","Java",120); } catch(IllegalArgumentException ex) { invalidScore=true; }
        assert invalidScore;
        boolean invalidAge=false;
        try { new Student("YOUNG","Young","Person",Gender.OTHER,LocalDate.now().minusYears(10),"","", "Testing",StudentLevel.ND1); }
        catch(IllegalArgumentException ex) { invalidAge=true; }
        assert invalidAge;
        System.out.println("All SchoolManagementTests passed.");
    }
}
