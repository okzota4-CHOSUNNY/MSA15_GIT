package shop.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shop.DTO.PersistenceLogins;
import shop.DTO.Users;
import shop.service.PersistenceLoginsService;
import shop.service.PersistenceLoginsServiceImpl;
import shop.service.UserService;
import shop.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 저장 쿠키 확인
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if( cookies[i].getName().equals("loginId") ) {
				request.setAttribute("loginId", cookies[i].getValue());
				break;
			}
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 비밀번호 가져오기
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 로그인 요청
		Users user = Users.builder()
						  .username(username)
						  .password(password)
						  .build();
		UserService userService = new UserServiceImpl();
		Users loginUser = userService.login(user);
		
		// 아이디 저장 체크 여부
		String rememberId = request.getParameter("remember-id");
		if( rememberId != null && rememberId.equals("on") ) {
			System.out.println("아이디 저장 체크");
			Cookie loginIdCookie = new Cookie("loginId", username);
			loginIdCookie.setMaxAge(60 * 60 * 24 * 7);	// 7일
			loginIdCookie.setPath("/");					// 전체 사이트에서 접근 가능
			response.addCookie(loginIdCookie);
		} else {
			System.out.println("아이디 저장 체크 해제");
			Cookie loginIdCookie = new Cookie("loginId", username);
			loginIdCookie.setMaxAge(0);					// 만료시간 0 -> 삭제
			loginIdCookie.setPath("/");					// 전체 사이트에서 접근 가능
			response.addCookie(loginIdCookie);
		}
		
		// 로그인 실패
		if( loginUser == null ) {
			// 다시 로그인 화면으로 이동
			response.sendRedirect("login.jsp?error=0");
			return;
		}
		
		// 로그인 성공
		HttpSession session = request.getSession();
		// 세션에 사용자 정보 등록 (아이디, 이름)
		session.setAttribute("username", loginUser.getUsername());
		session.setAttribute("name", loginUser.getName());
		
		// 자동 로그인 처리
		String rememberMe = request.getParameter("remember-me");
		PersistenceLogins login = null;
		if( rememberMe != null && rememberMe.equals("on") ) {
			PersistenceLoginsService persistenceLoginsService = new PersistenceLoginsServiceImpl();
			login = persistenceLoginsService.refresh(username);
		} else {
			// 자동 로그인 체크 해제
			Cookie tokenCookie = new Cookie("token", "");
			tokenCookie.setMaxAge(0);
			tokenCookie.setPath("/");
			response.addCookie(tokenCookie);
			
			Cookie rememberMeCookie = new Cookie("rememberMe", "");
			rememberMeCookie.setMaxAge(0);
			rememberMeCookie.setPath("/");
			response.addCookie(rememberMeCookie);
			
		}
		// 자동 로그인 처리 성공
		if( login != null ) {
			String token = login.getToken();
			Cookie tokenCookie = new Cookie("token", token);
			tokenCookie.setMaxAge(60 * 60 * 24 * 7);
			tokenCookie.setPath("/");
			response.addCookie(tokenCookie);
			
			Cookie rememberMeCookie = new Cookie("rememberMe", rememberMe);
			rememberMeCookie.setMaxAge(60 * 60 * 24 * 7);
			rememberMeCookie.setPath("/");
			response.addCookie(rememberMeCookie);
		}
		
		// 메인 화면으로 이동
		String root = request.getContextPath();
		response.sendRedirect(root + "/");
	}

}






