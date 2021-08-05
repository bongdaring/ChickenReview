package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Databaseuser;

public class ReviewDB {
	public int write(ReviewEntity reviewEntity) {
		//사용자가 리뷰 쓰는거
		String SQL = "INSERT INTO REVIEW VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, reviewEntity.getUserID());
			pstmt.setString(2, reviewEntity.getMenuName());
			pstmt.setString(3, reviewEntity.getOrderData());
			pstmt.setString(4, reviewEntity.getWhereOrder());
			pstmt.setString(5, reviewEntity.getTodayDate());
			pstmt.setString(6, reviewEntity.getReviewTitle());
			pstmt.setString(7, reviewEntity.getReviewContent());
			pstmt.setString(8, reviewEntity.getTotalScore());
			pstmt.setString(9, reviewEntity.getDelScore());
			pstmt.setString(10, reviewEntity.getDeliveryScore());
			pstmt.setString(11, reviewEntity.getServiceScore());
			pstmt.setString(12, reviewEntity.getPackingScore());
			pstmt.setString(13, reviewEntity.getChickenImage());
			pstmt.setString(14, reviewEntity.getBillImage());
			return pstmt.executeUpdate();
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -1; //데이터베이스 오류
	}
	
	
	
}
