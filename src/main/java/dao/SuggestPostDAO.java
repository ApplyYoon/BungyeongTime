package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class SuggestPostDAO {
	public void increase(String postId) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       System.out.println(postId);
        try {
        	conn = DBUtil.getConnection();
            String sql = "UPDATE post_tbl SET post_suggest = post_suggest + 1 WHERE post_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, postId);
            rs = pstmt.executeQuery();
            rs.next();
           
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
