package service;
import api.Loginable;
import model.StaffRole;
import java.util.Map;
/** Demonstration only: production systems must use salted password hashes and a secure user store. */
public class AuthService implements Loginable {
    private final Map<String, String> demoCredentials = Map.of("admin", "change-me", "teacher", "change-me");
    @Override public boolean login(String username, String password) {
        return username != null && password != null && password.equals(demoCredentials.get(username));
    }
    public boolean canManageStudents(StaffRole role) { return role == StaffRole.ADMIN; }
    public boolean canEnterResults(StaffRole role) { return role == StaffRole.ADMIN || role == StaffRole.TEACHER; }
}
