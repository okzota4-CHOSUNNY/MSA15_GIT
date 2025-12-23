package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class TestListner implements ServletContextListener {

    public TestListner() {
    	System.out.println("ServletContxetListener 객체 생성");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("TestListener - 웹 애플리케이션 시작!");
    	// DB연결 설정
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("TestListener - 웹 애플리케이션 종료!");
    	// 자원 해제
    }
	
}
