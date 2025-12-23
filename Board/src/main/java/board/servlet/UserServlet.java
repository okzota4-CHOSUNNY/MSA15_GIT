package board.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import board.DTO.Users;
import board.Service.UserService;
import board.Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
       
	/**
	 * [GET]
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// url : /users/idCheck
		String root = request.getContextPath();
		String path = request.getPathInfo();		// /idCheck
		
		// /idCheck - 아이디 중복 확인
		if( path.equals("/idCheck") ) {
			System.out.println("아이디 중복 확인...");
			String username = request.getParameter("username");
			boolean check = userService.idCheck(username);
			response.getWriter().print(check);
		}
		
		
		
		
	}

	/**
	 * [POST]
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();			// /Board
		String path = request.getPathInfo();			// /join
		
		
	}

}