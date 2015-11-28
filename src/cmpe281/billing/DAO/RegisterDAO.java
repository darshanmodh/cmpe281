package cmpe281.billing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	
	public static int addUser(String username, String password, String name, String email, String mobile, int roleid, int alertvalue) {
		
		Connection conn = null;
		PreparedStatement pst = null;
		int status = 0;
		String sql = "insert into user values (NULL,?,?,?,?,?,?,?)";
		
		conn = DBConnection.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, email);
			pst.setString(5, mobile);
			pst.setInt(6, roleid);
			pst.setInt(7, alertvalue);
			pst.executeUpdate();
			status = 1;
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
		}
		return status;
	}

}
