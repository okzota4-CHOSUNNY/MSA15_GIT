package encording;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/noencording")
public class NoEncordingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // GET 방식은 톰캣 기본 설정 따라 대부분 UTF-8이지만 명시하는 게 안전
        // (server.xml에 URIEncoding="UTF-8" 있으면 이 줄 없어도 됨)

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // POST는 무조건 이거 해줘야 함 (getParameter 호출 전에!)
        request.setCharacterEncoding("UTF-8");

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 응답 인코딩 + 컨텐트 타입 설정 (이게 제일 중요!)
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        if (name == null) name = "(없음)";

        PrintWriter out = response.getWriter();
        out.println("<h2>/noencording 결과</h2>");
        out.println("name : " + name + "<br>");
        out.println("encoding : 인코딩 제대로 설정했더니 한글이 안 깨짐!");
    }
}