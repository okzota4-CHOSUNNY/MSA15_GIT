package shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.DTO.Users;
import shop.service.UserService;
import shop.service.UserServiceImpl;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();  

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// forward 방식으로 회원가입 페이지로 이동(signup.jsp)
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 회원 객체 매핑
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Users user = Users.builder()
						  .username(username)
						  .password(password)
						  .name(name)
						  .email(email)
						  .enabled(true)
						  .build();
		// 회원가입 처리
		int result = userService.signup(user);
		String root = request.getContextPath();
		if( result > 0 ) {
			// 성공 -> 로그인 페이지로 이동
			response.sendRedirect(root + "/login.jsp");
		} else {
			// 실패 -> 다시 회원가입 페이지로 이동
			response.sendRedirect(root + "/signup.jsp?error=0");
		}
	}

}




