package shop.service;

import shop.DAO.UserDAO;
import shop.DTO.Users;
import shop.utils.PasswordUtils;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAO();
	
	@Override
	public int signup(Users user) {
		// 비밀번호 암호화
		// 123456 --> FA3123BC23F4ACE
		String encodedPassword 
			= PasswordUtils.encoded(user.getPassword());
		user.setPassword(encodedPassword);
		// 회원정보 등록 요청
		int result = userDAO.signup(user);
		if( result > 0 ) System.out.println("회원 가입 성공!");
		else 			 System.err.println("회원 가입 실패!");
		return result;
	}
	
	@Override
	public Users login(Users user) {
		String username = user.getUsername();
		Users selectedUser = userDAO.select(username);
		
		// 회원 가입이 안 된 아이디
		if( selectedUser == null ) 
			return null;
		
		// 비밀번호 일치 여부 확인
		String loginPassword = user.getPassword();
		String password = selectedUser.getPassword();
		
		// * BCrypt.checkpw(로그인 비밀번호, 암호호된 비밀번호);
		boolean check = PasswordUtils.check(loginPassword, password);
		
		// 비밀번호 불일치
		if( !check )
			return null;
		// 로그인 성공
		return selectedUser;
	}

	@Override
	public Users selectByUsername(String username) {
		Users user = userDAO.select(username);
		return user;
	}

}










