package shop.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import shop.DAO.PersistenceLoginsDAO;
import shop.DTO.PersistenceLogins;

public class PersistenceLoginsServiceImpl implements PersistenceLoginsService {
	
	private PersistenceLoginsDAO persistenceLoginsDAO = new PersistenceLoginsDAO();

	@Override
	public PersistenceLogins insert(String username) {
		// 현재 시각 + 7일 후 계산
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date expiryDate = calendar.getTime();
		
		// Builder 사용한 객체 생성
		PersistenceLogins login = PersistenceLogins.builder()
									.id(UUID.randomUUID().toString())
									.username(username)
									.token(UUID.randomUUID().toString())
									.expiryDate(expiryDate)
									.build();
		try {
			int result = persistenceLoginsDAO.insert(login);
			if( result > 0 ) System.out.println("자동 로그인 데이터 등록 성공!");
			else System.out.println("자동 로그인 데이터 등록 실패!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public PersistenceLogins select(String username) {
		PersistenceLogins login = null;
		try {
			login = persistenceLoginsDAO.selectByUseranme(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public PersistenceLogins selectByToken(String token) {
		PersistenceLogins login = null;
		try {
			login = persistenceLoginsDAO.selectByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public PersistenceLogins update(String username) {
		// 현재 시각 + 7일 후 계산
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date expiryDate = calendar.getTime();
		PersistenceLogins login = PersistenceLogins.builder()
									.id(UUID.randomUUID().toString())
									.username(username)
									.expiryDate(expiryDate)
									.updatedAt(new Date())
									.build();
		PersistenceLogins origin = null;
		int result = 0;
		try {
			origin = persistenceLoginsDAO.selectByUseranme(username);
			login.setNo(origin.getNo());
			login.setToken(origin.getToken());
			result = persistenceLoginsDAO.update(login);
			System.out.println("토큰 수정 여부 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public PersistenceLogins refresh(String username) {
		PersistenceLogins origin = null;
		PersistenceLogins refresh = null;
		
		try {
			origin = persistenceLoginsDAO.selectByUseranme(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 토큰이 없는 경우, 생성
		if( origin == null )
			refresh = insert(username);
		// 토큰이 있는 경우, 갱신
		else 
			refresh = update(username);
		return refresh;
	}

	@Override
	public boolean isValid(String token) {
		PersistenceLogins login = selectByToken(token);
		
		if( login == null ) return false;
		
		Date expiryDate = login.getExpiryDate();
		Date now = new Date();
		
		// 현재 시간보다 만료일이 나중이면 유효
		return expiryDate.after(now);
	}

	@Override
	public boolean delete(String username) {
		int result = 0;
		try {
			result = persistenceLoginsDAO.delete(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}
	
	
	

}




