package cmpe281.billing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static int validate(String username, String password) {

		boolean status = false;
		int role = 0;
		PreparedStatement pst = null;
		Connection conn;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		try {

			pst = conn.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);

			rs = pst.executeQuery();
			status = rs.next();
			role = rs.getInt(7);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role;
	}

}
