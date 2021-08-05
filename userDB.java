package usr;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Databaseuser;

public class userDB {

	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM user WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)){
					return 1; //로그인 성공
				}
				else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //아이디 없음
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -2; //데이터베이스 오류
	}
	
	public int join(userEntity user) {
		String SQL = "INSERT INTO user VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserAddress());
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
	
	public String getUserEmail(String userID) {
		String SQL = "SELECT userEmail FROM user WHERE userID=?";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{if(conn!=null)conn.close();}catch(Exception e) {e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return null; //데이터베이스 오류
		
	}
	public ArrayList<userEntity> getMemberlist(){
	       
        ArrayList<userEntity> list = null;
        Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
        try{//실행
        	String SQL = "SELECT * FROM user";
        	
    		conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            list = new ArrayList<userEntity>();
            while(rs.next()){
            	userEntity user = new userEntity(rs.getString(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4)
            			);
            	
                list.add(user);
            }
        }catch(Exception e){          
        	e.printStackTrace();       
        }finally {
			try{if(conn!=null)conn.close();}catch(Exception e) {e.printStackTrace();}
			try{if(pstmt!=null)pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try{if(rs!=null)rs.close();}catch(Exception e) {e.printStackTrace();}
		}  
        return list;
    }//getMemberlist
   

	
	public int delete(String userID) {
		String SQL = "DELETE FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Databaseuser.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
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
	
	
	
}
