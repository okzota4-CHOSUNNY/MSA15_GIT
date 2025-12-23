package content;

// 서블릿 실행을 위해 필요한 기본 라이브러리들
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

// 이 서블릿을 "/TextServlet" URL로 호출할 수 있게 설정
@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TextServlet() {
        super();   // HttpServlet 부모 생성자 호출
    }

    // ---------------------------------------------
    // 📌 doGet() : 브라우저가 GET 방식으로 요청할 때 실행됨
    // ---------------------------------------------
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // URL ?name=값  → 이런 식으로 전달된 데이터를 꺼내는 메서드
        // 예: /TextServlet?name=성진 → "성진"이 나오게 됨
        String name = request.getParameter("name");

        // 브라우저에게 텍스트를 보내기 위한 출력도구
        PrintWriter writer = response.getWriter();

        // 응답 내용 보내기 (브라우저 화면에 출력됨)
        writer.println("name : " + name);

        // 현재 프로젝트 컨텍스트 경로를 같이 출력해줌
        writer.append("Served at: ").append(request.getContextPath());
    }

    // ---------------------------------------------
    // 📌 doPost() : 브라우저가 POST 방식으로 요청할 때 실행됨
    // ---------------------------------------------
    @Override
    protected void doPost(
    		HttpServletRequest request, HttpServletResponse response
    		)throws ServletException, IOException {

        // POST 방식으로 전송된 "요청 바디(body)" 데이터를 한 줄씩 읽기 위한 준비
        BufferedReader reader = request.getReader();

        // 요청 바디 전체를 모으기 위한 객체
        StringBuilder sb = new StringBuilder();
        String line;

        // 요청 바디를 끝까지 읽어서 sb에 누적
        // (예: POST로 JSON, 텍스트, 폼데이터 등을 보낼 때)
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // 최종적으로 클라이언트가 보낸 원본 텍스트
        String requestText = sb.toString();

        // 서버 콘솔창에 출력 (브라우저 X)
        System.out.println("텍스트 : " + requestText);

        // -------------------------------------
        // 📌 여기까지가 "요청 읽기" 단계
        // -------------------------------------


        // -------------------------------------
        // 📌 여기서부터 "응답 보내기" 단계
        // -------------------------------------

        // 브라우저에게 보낼 응답 텍스트
        String responseText = "응답 메시지";

        // 응답을 UTF-8 로 처리 → 한글이 안 깨지도록 보장
        response.setContentType("text/plain; charset=UTF-8");

        // 브라우저로 텍스트를 보내는 Writer
        PrintWriter writer = response.getWriter();

        // 응답 본문(body)에 문자열 출력
        writer.println(responseText);
    }
}
