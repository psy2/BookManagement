package sevice.user;

import dao.user.UserDAO;
import entity.user.UserEntity;

public class UserService {
	public boolean login(UserEntity entity){
		boolean result=false;
		//로그인에 대한 로직처리를 해요!
		//Database 처리만 진행
		UserDAO dao=new UserDAO();
		result=dao.select(entity);
		
		return result;
	}
}
