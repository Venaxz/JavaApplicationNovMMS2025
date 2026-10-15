package repository;
import java.sql.*;
import java.util.*;
import model.*;
import java.time.LocalDate;
/**
 * JDBC adapter example. Configure a JDBC URL and install the matching database driver before use.
 * User values are bound with PreparedStatement parameters, not concatenated into SQL.
 */
public class JdbcStudentRepository {
    private final String url, username, password;
    public JdbcStudentRepository(String url, String username, String password) { this.url=url; this.username=username; this.password=password; }
    private Connection connect() throws SQLException { return DriverManager.getConnection(url, username, password); }
    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO students (student_id, first_name, last_name, gender, date_of_birth, email, phone, department_id, level, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c=connect(); PreparedStatement p=c.prepareStatement(sql)) {
            p.setString(1,s.getId()); p.setString(2,s.getFirstName()); p.setString(3,s.getLastName());
            p.setString(4,s.getGender().name()); p.setDate(5,Date.valueOf(s.getDateOfBirth()));
            p.setString(6,s.getEmail()); p.setString(7,s.getPhone()); p.setString(8,null);
            p.setString(9,s.getLevel().name()); p.setString(10,s.getStatus().name()); p.executeUpdate();
        }
    }
    public int countStudents() throws SQLException {
        try (Connection c=connect(); Statement s=c.createStatement(); ResultSet r=s.executeQuery("SELECT COUNT(*) FROM students")) {
            return r.next() ? r.getInt(1) : 0;
        }
    }
}
