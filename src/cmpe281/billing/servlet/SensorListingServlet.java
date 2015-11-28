package cmpe281.billing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmpe281.billing.DAO.Operation;

@WebServlet(urlPatterns = "/sensorlist")
public class SensorListingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();
		Operation operation = new Operation();
		String username = null;
		int userid = 0;
		ResultSet rs = null;
		ResultSet sensorResultSet = null;
		
		String isLoggedIn = (String) session.getAttribute("isLoggedIn");

		if (isLoggedIn != "user") {
			requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		} else { // get username from session
			try {
				username = (String) session.getAttribute("username");
				userid = operation.getUseridFromUsername(username);
				rs = operation.getInstancesFromUserid(userid);

				out.println("<P ALIGN='center'><TABLE BORDER=1>");
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				// table header
				out.println("<TR>");
				for (int i = 0; i < columnCount; i++) {
					out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
				}
				out.println("</TR>");
				// the data
				while (rs.next()) {
					out.println("<TR>");
					for (int i = 0; i < columnCount; i++) {
						out.println("<TD>" + rs.getString(i + 1) + "</TD>");
					}
					out.println("</TR>");
				}
				out.println("</TABLE></P>");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
