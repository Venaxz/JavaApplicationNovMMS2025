class Person { protected String id,name; Person(String id,String name){this.id=id;this.name=name;} String role(){return "School person";} }
class Student extends Person { Student(String id,String name){super(id,name);} @Override String role(){return "Student";} }
class Teacher extends Person { Teacher(String id,String name){super(id,name);} @Override String role(){return "Teacher";} }
public class SchoolPersonInheritanceDemo { public static void main(String[] args){System.out.println(new Student("ST003","Ada").role());System.out.println(new Teacher("T003","Chidi").role());} }
