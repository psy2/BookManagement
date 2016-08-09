package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.user.UserEntity;

public class UserDAO {
	
	public boolean select(UserEntity entity){
		boolean result=false;
		
		//DB처리가 나오면 되요!
		Connection con=common.DBTemplate.getConnection();
		String sql="select uid,upw,uname,uemail from user_tbl where uid=? and upw=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				result=true;
			}else{
				result=false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
