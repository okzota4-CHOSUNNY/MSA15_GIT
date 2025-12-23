package shop.filter;

import java.io.IOException;
import java.net.URLDecoder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import shop.DTO.PersistenceLogins;
import shop.DTO.Users;
import shop.service.PersistenceLoginsService;
import shop.service.PersistenceLoginsServiceImpl;
import shop.service.UserService;
import shop.service.UserServiceImpl;

@WebFilter(description = "자동 로그인 등 인증 처리 필터", urlPatterns = { "/*" })
public class LoginFilter extends HttpFilter implements Filter {

	PersistenceLoginsService persistenceLoginsService;
	UserService userService;
	
    public LoginFilter() {
        super();
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	persistenceLoginsService = new PersistenceLoginsServiceImpl();
    	userService = new UserServiceImpl();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 쿠키 확인
		// 1. 자동 로그인 여부
		// 2. 인증 토큰 검증
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie[] cookies = httpRequest.getCookies();
		
		String rememberMe = null;		// 자동 로그인 여부
		String token = null;			// 인증 토큰
		if( cookies != null ) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = URLDecoder.decode( cookie.getValue(), "UTF-8" );
				switch( name ) {
					case "rememberMe" 	: rememberMe = value; break;
					case "token" 		: token = value; break;
				}
			}
		}
		System.out.println("LoginFilter...");
		System.out.println("rememberMe : " + rememberMe);
		System.out.println("token : " + token);
		
		// 로그인 여부 확인
		HttpSession session = httpRequest.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		// 이미 로그인 됨
		if( loginId != null ) {
			chain.doFilter(request, response);
			System.out.println("로그인된 사용자  : " + loginId);
			return;
		}
		
		// 자동 로그인 & 토큰 OK
		if( rememberMe != null && token != null ) {
			System.out.println("rememberMe : " + rememberMe);
			System.out.println("token : " + token);
			PersistenceLogins persistenceLogins = persistenceLoginsService.selectByToken(token);
			System.out.println("persistenceLogins : " + persistenceLogins);
			boolean isValid = persistenceLoginsService.isValid(token);
			// 토큰이 존재 & 유효 OK
			if( persistenceLogins != null && isValid ) {
				loginId = persistenceLogins.getUsername();
				Users user = userService.selectByUsername(loginId);
				String name = user.getName();
				System.out.println("loginId : " + loginId);
				// 로그인 처리
				session.setAttribute("username", loginId);
				session.setAttribute("name", name);
				System.out.println("자동 로그인 성공!");
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}




