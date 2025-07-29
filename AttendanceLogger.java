import java.sql.*;

public class AttendanceLogger {
    public static void log(String studentId) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:attendance.db")) {
            String sql = "INSERT INTO attendance (student_id, timestamp) VALUES (?, datetime('now'))";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentId);
            stmt.executeUpdate();
            System.out.println("Attendance logged for " + studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
