package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class RegisterDAO {
	public void regist(String userId, String userPassword, String userName) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	conn = DBUtil.getConnection();
        	String sql = "INSERT INTO user_tbl VALUES(?, ?, ?)";
        	pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, userId);
	        pstmt.setString(2, userPassword);
	        pstmt.setString(3, userName);
	        pstmt.executeUpdate();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
			DBUtil.close(conn, pstmt, rs);
		}
        return;
	}
}
