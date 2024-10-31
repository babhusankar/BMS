package Bms;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkOrderDAO {
    public List<WorkOrder> getAllWorkOrders() throws SQLException {
        List<WorkOrder> workOrders = new ArrayList<>();
        String query = "SELECT * FROM work_orders";

        try (Connection conn = DatabaseConf.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                WorkOrder order = new WorkOrder();
                order.setOrderId(rs.getInt("order_id"));
                order.setClientName(rs.getString("client_name"));
                order.setDate(rs.getString("date"));
                order.setStatus(rs.getString("status"));
                workOrders.add(order);
            }
        }
        return workOrders;
    }
}
