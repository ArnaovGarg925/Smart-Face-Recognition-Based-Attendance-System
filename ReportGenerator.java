import java.sql.*;

public class ReportGenerator {
    public static void generateReport() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:attendance.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT student_id, COUNT(*) as days_present FROM attendance GROUP BY student_id");

            System.out.println("Attendance Report:");
            while (rs.next()) {
                System.out.println(rs.getString("student_id") + ": " + rs.getInt("days_present") + " days");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
