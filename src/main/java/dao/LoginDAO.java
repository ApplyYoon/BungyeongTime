package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import util.DBUtil;

public class LoginDAO {
	public Map<String, String> login(String userId) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Map<String, String> map = new HashMap<>();
        try {
        	conn = DBUtil.getConnection();
            String sql = "SELECT user_pw, user_name FROM user_tbl WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            rs.next();
            
            String user_pw = rs.getString("user_pw");
            String user_name = rs.getString("user_name");
           
            map.put("user_name", user_name);
            map.put("user_pw", user_pw);
    		return map;
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
			DBUtil.close(conn, pstmt, rs);
		}
        return map;
	}
}
