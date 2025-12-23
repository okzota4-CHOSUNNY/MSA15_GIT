package encording;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/encoding")
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EncodingServlet() {
        super();
    }


	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8;");
			
		// 1. 응답의 문자 인코딩을 UTF-8로 강제 설정
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 2. 응답을 쓰기 위한 Writer 객체 가져오기
		PrintWriter writer = response.getWriter();

		// 3. 요청 파라미터 "name" 값을 가져오기 (없으면 null)
		String name = request.getParameter("name");

		// 4. 이름 출력
		writer.println("name : " + name);

		// 5. 인코딩 테스트를 위한 출력 (한글이 깨지는지 확인용)
		writer.println("encoding : 인코딩 설정 (UTF-8)");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
