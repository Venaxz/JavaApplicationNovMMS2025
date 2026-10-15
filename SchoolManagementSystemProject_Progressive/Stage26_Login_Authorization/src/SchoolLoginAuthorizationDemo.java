import java.util.*;
enum UserRole { ADMIN, TEACHER, STUDENT }
class SchoolUser {String username;UserRole role;SchoolUser(String u,UserRole r){username=u;role=r;}}
public class SchoolLoginAuthorizationDemo { static boolean canManagePayments(SchoolUser u){return u.role==UserRole.ADMIN;} public static void main(String[] args){List<SchoolUser> users=Arrays.asList(new SchoolUser("admin",UserRole.ADMIN),new SchoolUser("teacher1",UserRole.TEACHER),new SchoolUser("student1",UserRole.STUDENT));for(SchoolUser u:users)System.out.println(u.username+" role="+u.role+" can manage payments="+canManagePayments(u));System.out.println("Demo only: production login must use hashed passwords and secure session handling.");} }
