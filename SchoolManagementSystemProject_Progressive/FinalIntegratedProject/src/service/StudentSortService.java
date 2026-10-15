package service;
import model.Student;
import java.util.*;
public class StudentSortService {
    public List<Student> byId(List<Student> students) { List<Student> copy=new ArrayList<>(students); Collections.sort(copy); return copy; }
    public List<Student> byAge(List<Student> students) { List<Student> copy=new ArrayList<>(students); copy.sort(Comparator.comparingInt(Student::getAge)); return copy; }
    public List<Student> byDepartment(List<Student> students) { List<Student> copy=new ArrayList<>(students); copy.sort(Comparator.comparing(Student::getDepartment)); return copy; }
}
