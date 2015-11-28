package cmpe281.billing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmpe281.billing.DAO.RegisterDAO;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        int roleid = 2;
        int alertvalue = 0;
        try {
        	alertvalue = Integer.parseInt(request.getParameter("alertvalue"));
		} catch (NumberFormatException e) {
			out.print("<p style=\"color:red\">Alert Value should be numeric</p>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			e.printStackTrace();
			return;
			// TODO: handle exception
		}
        
        HttpSession session = request.getSession();
        
        if(password.equals(cpassword)){
        	int status = RegisterDAO.addUser(username, password, name, email, mobile, roleid, alertvalue);
        	if (status == 1) {
        		out.print("<p style=\"color:blue\">User inserted successfully!!!</p>");
    			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    			rd.include(request, response);
        	} else {
        		out.print("<p style=\"color:red\">Registration Failed</p>");
    			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
    			rd.include(request, response);
        	}
        	
        } else {
        	out.print("<p style=\"color:red\">Registration Failed: Password Mismatch</p>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
        }
	}

}
