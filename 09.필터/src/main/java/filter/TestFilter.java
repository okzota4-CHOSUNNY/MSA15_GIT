package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/TestFilter")
public class TestFilter extends HttpFilter implements Filter {
       
    /**
     * 필터가 제거될 때 호출되는 메소드
     */
    public TestFilter() {
        super();
    }

	/**
	 * 필터에서 처리할 작업을 작성하는 메소드
	 */
	public void destroy() {
	}

	/**
	 * 필터에서 처리 할 작업을 작성하는 메소드
	 */
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
		chain.doFilter(request, response);
		
		System.out.println("TestFilter 필터 처리 작업....");
	}

	/**
		필터를 초기화하는 메소드
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("TestFilter 초기화...");
	}

}
