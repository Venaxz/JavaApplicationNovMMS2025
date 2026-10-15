import java.util.*;
class Repository<T> { private final List<T> records=new ArrayList<>(); public void add(T item){records.add(item);} public List<T> findAll(){return new ArrayList<>(records);} }
class GenericStudent { String id; GenericStudent(String id){this.id=id;} public String toString(){return id;} }
public class GenericRepositoryDemo { public static void main(String[] args){Repository<GenericStudent> students=new Repository<>();students.add(new GenericStudent("ST11"));students.add(new GenericStudent("ST12"));Repository<String> notices=new Repository<>();notices.add("Exam timetable published");System.out.println(students.findAll());System.out.println(notices.findAll());} }
