import java.time.LocalDate;
class SchoolStudent { String id, name, department; SchoolStudent(String id,String name,String department){this.id=id;this.name=name;this.department=department;} void display(){System.out.println(id+" | "+name+" | "+department);} }
class SchoolTeacher { String id,name,subject; SchoolTeacher(String id,String name,String subject){this.id=id;this.name=name;this.subject=subject;} void display(){System.out.println(id+" | "+name+" | teaches "+subject);} }
public class SchoolPersonModelDemo { public static void main(String[] args){SchoolStudent s=new SchoolStudent("ST001","Ada Okafor","Computing");SchoolTeacher t=new SchoolTeacher("T001","Chidi Bello","Java");s.display();t.display();System.out.println("Objects created on "+LocalDate.now());} }
