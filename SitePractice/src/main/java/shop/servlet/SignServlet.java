package shop.servlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.DTO.Users;
import shop.service.UserService;
import shop.service.UserServiceImpl;

/**
 * 회원가입 요청 처리 Servlet 
 */

@WebServlet("/signup")
// /signup 주소로 들어오는 요청을 이 서블릿이 처리
public class SignServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	// Servlet 직렬화용 ID(경고 방지)

	private UserService userService = new UserServiceImpl();
	// Service 객체 생성
	// 실제 구현체는 UserServiceImpl
	
	/**
	 * 회원가입 요청 처리(POST)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		// 1. 클라이언트에서 보낸 값 꺼내기
		String username = request.getParameter("username");
		// name="username" input 값
		
		String password = request.getParameter("password");
		// name="password" input 값
		
        String name = request.getParameter("name");
        // name="name" input 값

        String email = request.getParameter("email");
        // name="email" input 값
        
        // 2.DTO로 묶기
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        // Lombok @Data 덕분에 setter 사용 가능
        
        // 3. 회원가입 처리 (Service 호출)
        int result = userService.signup(user);
        
        // 4. 컨텍스트 경로
        String root = request.getContextPath();
        
        // 5. 결과에 따라 페이지 이동
        if (result > 0) {
        	// 성공 → 로그인 페이지
        	response.sendRedirect(root + "/login.jsp");
        } else {
        	// 실패 → 회원가입 페이지로 다시
        	response.sendRedirect(root + "/signup.jsp?error=1");
        }
        	
	}
	
}















