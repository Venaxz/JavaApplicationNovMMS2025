abstract class SchoolPerson { private final String name; SchoolPerson(String name){this.name=name;} public String getName(){return name;} public abstract String describeRole(); public void printProfile(){System.out.println(getName()+": "+describeRole());} }
class AbstractStudent extends SchoolPerson { AbstractStudent(String name){super(name);} public String describeRole(){return "Enrolled student";} }
class AbstractTeacher extends SchoolPerson { AbstractTeacher(String name){super(name);} public String describeRole(){return "Teaching staff";} }
public class AbstractSchoolPersonDemo { public static void main(String[] args){new AbstractStudent("Ada").printProfile();new AbstractTeacher("Chidi").printProfile();} }
