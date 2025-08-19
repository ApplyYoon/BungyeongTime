package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private static final String USER = "system";
	    private static final String PASSWORD = "1234";

	    public static Connection getConnection() throws Exception {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	     public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
	        try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

}
