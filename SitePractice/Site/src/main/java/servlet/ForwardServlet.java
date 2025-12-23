package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/forwad")
public class ForwardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 요청정보 전달
        request.setAttribute("msg", "servlet 에서 forward 방식으로 이동");
        
        // forward 방식으로 이동
        // : request자체가 최상위 경로로 이동 (웹앱의 최상위경로) 기준으로 이동됨
        // 따라서, 컨텍스트 패스 사용하지 않아도 됨.
        RequestDispatcher dispatcher
            = request.getRequestDispatcher("/servlet/forward/detail.jsp");
        dispatcher.forward(request, response);
    }
}
