package method;

import jakarta.servlet.ServletException;	// 서블릿 처리중 예외 타입
import jakarta.servlet.ServletInputStream;	// HTTP 요청의 바디(body)를 바이트 스트림으로 읽을 때 사용
import jakarta.servlet.annotation.MultipartConfig; // 파일 업로드 등 multipart/form-data 형식 요청을 처리하기 위한 설정
import jakarta.servlet.annotation.WebServlet; // 이 클래스가 서블릿이며, 어떤 URL과 연결되는지(매핑) 지정
import jakarta.servlet.http.HttpServlet; // 모든 HTTP 서블릿의 부모 클래스
import jakarta.servlet.http.HttpServletRequest; // 클라이언트가 보낸 요청 정보(파라미터, 헤더 등)를 담는 객체
import jakarta.servlet.http.HttpServletResponse; // 서버가 클라이언트에게 보낼 응답 정보를 담는 객체
import jakarta.servlet.http.Part; // 업로드된 파일이나 각 파트(폼 필드)를 표현하는 객체

import java.io.IOException; // 입출력 처리 중 발생하는 예외 타입
import java.io.PrintWriter; // 응답 본문에 텍스트를 쓰기위한 출력 도구
import java.util.Map;	// key-value 구조의 자료구조(JSON > MAP 변환시 사용)

import com.fasterxml.jackson.core.type.TypeReference; // Jackson 라이브러리에서 제공
import com.fasterxml.jackson.databind.ObjectMapper; // Jackson 라이브러리에서 제공


// MultipartConfig
//  -> Content-Type: multipart/form-data
@MultipartConfig
// 위 주석의 내용: 이 서블릿은 multipart/form-data 요청(파일 업로드 등)을 처리할 것이라는 설명.


@WebServlet("/method")
public class MethodServlet extends HttpServlet {
	// HttpServlet을 상속하여 HTTP 요청을 처리하는 서블릿이 됨
	private static final long serialVersionUID = 1L;
		// 직렬화 관련 ID 서블릿 클래스 버전 관리용 값이라 생각하면 충분(넘어가자)
	// 이 서블릿을 /method ULR과 매핑합니다.
	// 즉 브라우저에서 /프로젝트명/method 로 요청하면 이 클래스가 실행 됨
	
	
	// GET
	// - /method?name=김조은&age=20
	// - 요청 파라미터 : name, age
	protected void doGet(
			HttpServletRequest request,
			// 요청정보 (쿼리 파라미터 등)
			HttpServletResponse response
			// 응답정보 (헤더, 바디 등)
			) throws ServletException, IOException {
		try {
			// 요청
			String name = request.getParameter("name");
			// URL 뒤에 붙은 ?name=값 에서 "값" 을 문자열로 가져온다
			int age = Integer.parseInt(request.getParameter("age"));
			// ?age=20 에서 "20" 문자열을 가져옵니다.
			System.out.println("name : " + name);
			System.out.println("age " + age);
			
			//응답
			response.setContentType("text/html; charset=UTF-8");
			// 응답이 HTML문서이고, 문자 인코딩은 UTF-8이라고 브라우저에 알려줌
			PrintWriter writer = response.getWriter();
			// 응답 본문에 텍스트를 쓰기 위한 출력 스트림(Writer)을 얻음			
			writer.println("<h1>name: " + name + "</h1>");
			writer.println("<h1>age: " + age + "</h1>");
			writer.flush();
			// 버퍼에 쌓인 출력 내용을 바로 클라이언트로 전송
			} catch (Exception e) {
			System.err.println("파라미터가 올바르지 않습니다");
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	// POST
	// - /method
	// - body : username, password
	/*
	 * Content-Type : application/x-www-form-urlencoded 경우,
	 * <form> 요청으로 인식하고, request.getParameter()를 호출하면
	 * 본문(body) 에서 데이터를 가져온다.
	 */
	
	/*
	 *  Content-Type : multipart/form-data 의 경우는
	 *  request.getParameter() 로 전달된 본문 데이터를 가져올 수 없다!
	 *  request.getPart("file") 로 전달된 파일 데이터를 가져와야한다.
	 */
	
	protected void doPost(
		// POST방식으로 /method에 요청이 들어오면 호출이 됨
		HttpServletRequest request,
		
		HttpServletResponse response
		) throws ServletException, IOException {
		// 요청
		// 텍스트 데이터 -> getParameter
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("아이디 : " + username );
		writer.println("비밀번호 : " + password );
		// 파일
		Part file = request.getPart("file");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		
		writer.println("<h1>아이디 : " + username + "</h1>");
		writer.println("<h1>비밀번호 : " + password + "</h1>");
		writer.println("<h1>파일명 : " + file.getSubmittedFileName() + "</h1>");

	}

	// PUT
	// -/method
	// -컨텐츠 타입: JSON
	// -요청 본문(body)
	//	{"no" : "1", "title": "제목", "content" : "내용"}
	protected void doPut(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		// 요청 (JSON -> Map)
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream sis = request.getInputStream();
		Map<String, Object> map 
		    = mapper.readValue(sis, new TypeReference<Map<String, Object>>() {});

		String no = (String) map.get("no");
		String title = (String) map.get("title");
		String content = (String) map.get("content");

		System.out.println("no : " + no);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>no : " + no + "</h1>");
		writer.print("<h1>title : " + title + "</h1>");
		writer.print("<h1>content : " + content + "</h1>");
	}

	// DELETE
	// - /method?no=10
	protected void doDelete(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
			String noString = request.getParameter("no");
			int no = 0;
			try {
				no = Integer.parseInt(noString);
			} catch (Exception e) {
				System.err.println("유효하지 않은 번호입니다.");
			}
			
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println(no + "번 글을 삭제하였습니다.");
	}

}
