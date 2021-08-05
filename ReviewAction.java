package review;

import java.sql.*;
import java.util.ArrayList;

import util.Databaseuser;

public class ReviewAction {
	public ArrayList<ReviewEntity> getList() {
		ArrayList<ReviewEntity> reviewList = null;
		String SQL = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			SQL = "SELECT * FROM review ORDER BY userID ASC";
			
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<ReviewEntity>();
			while (rs.next()) {
				ReviewEntity review = new ReviewEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getInt(16));
				reviewList.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reviewList; // 데이터베이스 오류
	}
	public ArrayList<ReviewEntity> getList(String arrangeType, String search, int pageNumber) {
		ArrayList<ReviewEntity> reviewList = null;
		String SQL = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (arrangeType.equals("최신등록순")) {
				SQL = "SELECT * FROM review WHERE CONCAT(menuName, whereOrder, reviewTitle, reviewContent, userID) LIKE ? "
						+ "ORDER BY reviewID DESC LIMIT " + pageNumber*5+", "+ pageNumber * 5 + 6;
			} else if (arrangeType.equals("추천수순")) {
				SQL = "SELECT * FROM review WHERE CONCAT(menuName, whereOrder, reviewTitle, reviewContent, userID) LIKE ? "
						+ "ORDER BY likeCount DESC LIMIT " + pageNumber*5+", "+ pageNumber * 5 + 6;
			} else if (arrangeType.equals("랭킹순")) {
				SQL = "SELECT * FROM review WHERE CONCAT(menuName, whereOrder, reviewTitle, reviewContent, userID) LIKE ? "
						+ "ORDER BY totalScore DESC LIMIT " + pageNumber*5+", "+ pageNumber * 5 + 6;
			}

			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<ReviewEntity>();
			while (rs.next()) {
				ReviewEntity review = new ReviewEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getInt(16));
				reviewList.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reviewList; // 데이터베이스 오류
	}

	public int like(String reviewID) {
		String SQL = "UPDATE REVIEW SET likeCount = likeCount + 1 WHERE reviewID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(reviewID));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터베이스 오류
	}

	public int delete(String reviewID) {
		String SQL = "DELETE FROM REVIEW WHERE reviewID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(reviewID));
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터베이스 오류
	}

	public String getUserID(String reviewID) {
		String SQL = "SELECT userID FROM REVIEW WHERE reviewID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(reviewID));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null; // 존재하지않음
	}
}
