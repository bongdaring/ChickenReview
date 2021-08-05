package recommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.Databaseuser;

public class RecommandDB {
	public int like(String userID, String reviewID, String userIP) {
		String SQL = "INSERT INTO LIKEY VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, reviewID);
			pstmt.setString(3, userIP);
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e) {e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -1; //회원가입 실패
	}

}