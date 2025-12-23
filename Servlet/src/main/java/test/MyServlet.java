package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("Hello World");
        writer.println("<br>");

        // HTTP 요청 메소드
        String method = request.getMethod();
        writer.println("HTTP 요청 메소드 : " + method);
        writer.println("<br>");

        // 요청 파라미터
        String paramValue = request.getParameter("paramName");
        writer.println("파라미터 값: " + paramValue);
        writer.println("<br>");

        // 요청 URI
        String requestURI = request.getRequestURI();
        writer.println("요청 URI : " + requestURI);
        writer.println("<br>");

        // 요청 URL
        StringBuffer requestURL = request.getRequestURL();
        writer.println("요청 URL : " + requestURL.toString());
        writer.println("<br>");

        // User-Agent 헤더
        String userAgent = request.getHeader("User-Agent");
        writer.println("User-Agent 헤더 : " + userAgent);
        writer.println("<br>");

        // 클라이언트 IP 주소
        String remoteAddr = request.getRemoteAddr();
        writer.println("클라이언트 IP 주소 : " + remoteAddr);
        writer.println("<br>");

        writer.append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        doGet(request, response);
    }
}
