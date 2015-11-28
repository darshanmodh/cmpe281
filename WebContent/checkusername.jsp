<%@ page import="java.io.*,java.sql.*"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String sn = request.getParameter("ver");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "");
	PreparedStatement pst = con.prepareStatement("select * from user where username=?");
	pst.setString(1, sn);
	ResultSet rs = pst.executeQuery(); // this is for name
	if (rs.next()) {
%>
<font color=red> Name already taken 
	<input type="hidden" id="actual" name="actual" value="taken">
</font>

<%
	} else {
%>
<font color=green> <input type="hidden" id="actual" name="actual"
	value="available"> Available
</font>
<%
	}
%>

<%
	rs.close();
	pst.close();
	con.close();
%>