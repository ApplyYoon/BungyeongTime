package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import util.DBUtil;

public class PostDetailDAO {
	public Map<String, String> get(String postId) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Map<String, String> map = new HashMap<>();
        try {
        	conn = DBUtil.getConnection();
            String sql = "SELECT * FROM post_tbl WHERE post_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, postId);
            rs = pstmt.executeQuery();
            rs.next();
            
            String title = rs.getString("post_title");
            String content = rs.getString("post_content");
            String suggest = rs.getString("post_suggest");
            String name = rs.getString("user_name");
            map.put("title", title);
            map.put("content", content);
            map.put("suggest", suggest);
            map.put("name", name);
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
