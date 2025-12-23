package encording;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
			@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter extends HttpFilter implements Filter {
	String encoding;
	FilterConfig filterConfig;
	
	// 생성자
    public EncodingFilter() {
        super();
    }
    // 필터 초기화 메소드
    public void init(FilterConfig filterConfig) throws ServletException {
       this.filterConfig = filterConfig;
       encoding = filterConfig.getInitParameter("encoding"); // UTF-8
       System.out.println("필터 초기화 - encoding : " + encoding);
    }
    
	// 필터 작업 메소드   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("인코딩 필터 : " + encoding);
    	// 인코딩 설정
    	request.setCharacterEncoding(encoding);
    	response.setCharacterEncoding(encoding);
    	response.setContentType("text/plain; charset=" + encoding);
    	
    	// 다음 필터를 호출
    	chain.doFilter(request, response);
    }
    // 필터 소멸 메소드
	public void destroy() {
		// TODO Auto-generated method stub
	}


}
