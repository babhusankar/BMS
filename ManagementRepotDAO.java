package Bms;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagementRepotDAO {
    public List<ManagementRepo> getAllReports() throws SQLException {
        List<ManagementRepo> reports = new ArrayList<>();
        String query = "SELECT * FROM management_reports";

        try (Connection conn = DatabaseConf.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ManagementRepo report = new ManagementRepo();
                report.setId(rs.getInt("id"));
                report.setReportName(rs.getString("report_name"));
                report.setGeneratedDate(rs.getString("generated_date"));
                reports.add(report);
            }
        }
        return reports;
    }
}