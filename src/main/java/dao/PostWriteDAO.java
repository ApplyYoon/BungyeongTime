package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBUtil;

public class PostWriteDAO {
	public void write(String userId, String title, String content) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	conn = DBUtil.getConnection();
        	String sql = "SELECT NVL(MAX(TO_NUMBER(post_id)), 0) + 1 AS next_post_id FROM post_tbl";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        rs.next();
	        String post_id = rs.getString("next_post_id");
	        System.out.println(post_id);
	        sql = "INSERT INTO post_tbl VALUES(?, ?, ?, ?, 0, 0)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, post_id);
	        pstmt.setString(2, userId);
	        pstmt.setString(3, title);
	        pstmt.setString(4, content);
	        pstmt.executeQuery();
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