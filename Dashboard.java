package Bms;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
    private CaseDAO caseDAO = new CaseDAO();
    private ManagementReportDAO reportDAO = new ManagementReportDAO();
    private WorkOrderDAO workOrderDAO = new WorkOrderDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            List<Case> cases = caseDAO.getAllCases();
            List<ManagementReport> reports = reportDAO.getAllReports();
            List<WorkOrder> workOrders = workOrderDAO.getAllWorkOrders();

            Map<String, Object> data = new HashMap<>();
            data.put("cases", cases);
            data.put("reports", reports);
            data.put("workOrders", workOrders);

            String json = new Gson().toJson(data);
            out.print(json);
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

