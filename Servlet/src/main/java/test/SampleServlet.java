package test;

import java.io.IOException;		// 에러(예외) 타입
import java.io.PrintWriter;		// 브라우저로 글자를 보내는 도구

import jakarta.servlet.ServletException; 	// 에러(예외) 타입
import jakarta.servlet.http.HttpServlet;	// 서블릿의 부모 클래스
import jakarta.servlet.http.HttpServletRequest;	// 클라이언트 요청 정보(주소, 파라미터 등)를 담는 객체
import jakarta.servlet.http.HttpServletResponse; // 서버 응답 정보(헤더, 바디 등)를 담는 객체

// web.xml 에 서블릿 매핑
public class SampleServlet extends HttpServlet {
// extends선언은 나는 일반 클래스가 아니라 웹요청을 처리할 수 있는 서블릿 이라고 선언하는 부분

	@Override
	protected void doGet(
			// 브라우저가 주소창에 URL을 치고 들어올 때, 링크를 클릭할때 GET요청이 들어옴
	        HttpServletRequest request,
	        // 들어온 요청에 대한 정보가 담겨있는 객체
	        HttpServletResponse response
	        // 우리가 브라우저에게 돌려보낼 응답을 만드는 도구
	) throws ServletException, IOException {
		
		/** 이 메서드가 실행 도중 서블릿 관련 에러나 입출력(IO) 관련 에러가 나면
		밖으로 예외를 던질 수 있다는 선언입니다. (try-catch 대신 이렇게 선언해 둔 것) 
		**/
		
	    response.setContentType("text/plain; charset=UTF-8");
	    PrintWriter writer = response.getWriter();
	    writer.println("web.xml 요청경로 매핑");
	}

	
		
}
