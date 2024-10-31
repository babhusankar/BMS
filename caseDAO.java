package Bms;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class caseDAO {
	    public List<Case> getAllCases() throws SQLException {
	        List<Case> cases = new ArrayList<>();
	        String query = "SELECT * FROM cases";

	        try (Connection conn = DatabaseConf.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                Case c = new Case();
	                c.setId(rs.getInt("id"));
	                c.setCaseType(rs.getString("case_type"));
	                c.setStatus(rs.getString("status"));
	                c.setCreatedDate(rs.getString("created_date"));
	                cases.add(c);
	            }
	        }
	        return cases;
	    }
}
