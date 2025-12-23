package shop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shop.DTO.Users;
import shop.service.UserService;
import shop.service.UserServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
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
		
		//로그인 실패
		if( loginUser == null ) {
			// 다시 로그인 화면으로 이동
			response.sendRedirect("login.jsp?error=0");
			return;
		}
		
		// 로그인 성공
		HttpSession session = request.getSession();
		if( loginUser != null ) {
			// 세션에 사용자 정보 등록 (아이디, 이름)
			session.setAttribute("username", loginUser.getUsername());
			session.setAttribute("name", loginUser.getName());
			// 메인 화면으로 이동
			String root = request.getContextPath();
			response.sendRedirect(root + "/");
		}
		
		
	}
}
