package board.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import board.DTO.Users;
import board.Service.UserService;
import board.Service.UserServiceImpl;

@WebServlet({"/join", "/join.jsp"})
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 화면
		String url = "/page/join.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리
		System.out.println("회원가입 요청 처리...");
		String root = request.getContextPath();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Users user = Users.builder()
						  .id( UUID.randomUUID().toString() )
						  .username(username)
						  .password(password)
						  .name(name)
						  .email(email)
						  .build();
		int result = userService.join(user);
		// 회원가입 성공
		if( result > 0 ) {
			response.sendRedirect(root + "/");
		} 
		// 회원가입 실패
		else {
			response.sendRedirect(root + "/join.jsp?error=true");
		}
		// [회원가입 끝] ##############################################################
	}

}