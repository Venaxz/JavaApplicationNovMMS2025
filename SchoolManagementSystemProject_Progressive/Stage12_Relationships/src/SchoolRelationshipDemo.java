import java.util.*;
class Department { String name; List<SchoolCourse> courses=new ArrayList<>(); Department(String name){this.name=name;} void addCourse(SchoolCourse c){courses.add(c);} }
class SchoolCourse { String code,title; SchoolTeacher teacher; SchoolCourse(String code,String title){this.code=code;this.title=title;} }
class SchoolTeacher { String name; SchoolTeacher(String name){this.name=name;} }
public class SchoolRelationshipDemo { public static void main(String[] args){Department d=new Department("Computing");SchoolCourse c=new SchoolCourse("CSC101","Java Programming");c.teacher=new SchoolTeacher("Mr Bello");d.addCourse(c);System.out.println(d.name+" department has "+d.courses.size()+" course(s): "+c.title+", taught by "+c.teacher.name);System.out.println("Department aggregates courses; course is associated with a teacher.");} }
