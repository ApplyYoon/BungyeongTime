package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.PostDTO;
import util.DBUtil;

public class PostListDAO {

    public List<PostDTO> selectAllPosts() {
        List<PostDTO> posts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM post_tbl";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                PostDTO post = new PostDTO();
                post.setUserId(rs.getString("user_id"));
                post.setPostId(rs.getString("post_id"));
                post.setTitle(rs.getString("post_title"));
                post.setContent(rs.getString("post_content"));
                post.setSuggest(rs.getString("post_suggest"));
                post.setReport(rs.getString("post_report"));

                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }

        return posts;
    }
}
