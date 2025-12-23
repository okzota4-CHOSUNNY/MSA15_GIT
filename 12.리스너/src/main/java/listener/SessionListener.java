package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    	System.out.println("세션 리스너 객체 생성");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	String sessionId = se.getSession().getId();
    	se.getSession().setMaxInactiveInterval(60);	// 세션 유효시간을 1분으로 지정
    	System.out.println("세션 생성 - SESSIONID : " + sessionId);
    	System.out.println("------------------");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	String sessionId = se.getSession().getId();
    	System.out.println("세션 종료 - SESSIONID : " + sessionId);
    	System.out.println("------------------");
    }
	
}
