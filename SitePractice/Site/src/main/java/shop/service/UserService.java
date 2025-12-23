package shop.service;

import shop.DTO.Users;

public interface UserService {
	
	// 회원가입
	public int signup(Users user);
	
	// 로그인
	public Users login(Users user);
	
	// 아이디로 조회
	public Users selectByUsername(String username);

}