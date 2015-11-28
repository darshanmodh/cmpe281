package cmpe281.billing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operation {
	
	PreparedStatement pst = null;
	Connection conn;
	ResultSet rs = null;
	
	public int getUseridFromUsername(String username) {
		
		boolean status = false;
		int userid = 0;

		conn = DBConnection.getConnection();
		try {

			pst = conn.prepareStatement("select userid from user where username=?");
			pst.setString(1, username);

			rs = pst.executeQuery();
			status = rs.next();
			userid = rs.getInt(1);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return userid;
	}

	public ResultSet getInstancesFromUserid(int userid) {
		
		conn = DBConnection.getConnection();
		try {
			pst = conn.prepareStatement("SELECT v.instanceid, s.location, s.rate, v.state "
					+ "FROM virtualizer v INNER JOIN sensor s "
					+ "ON s.sensorid = v.sensorid and v.userid=1");
			//pst.setInt(1, userid);
			
			rs = pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return rs;
	}

	public ResultSet getSensorFromSensorid(int sensorid) {
		
		conn = DBConnection.getConnection();
		try {
			pst = conn.prepareStatement("select location, rate from sensor where sensorid=?");
			pst.setInt(1, sensorid);
			
			rs = pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return rs;
		
	}
}
