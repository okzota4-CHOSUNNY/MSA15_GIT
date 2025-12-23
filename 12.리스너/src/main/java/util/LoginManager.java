package util;

import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

/*
 * 로그인 계정 관리 클래스
 * - 싱글톤 패턴
 * - 인증된 사용자 정보
 */
public class LoginManager {

    private static LoginManager loginManager = null;
    private static Hashtable<String, String> loginUsers = new Hashtable<>();

    private LoginManager() {
    }

    public static synchronized LoginManager getInstance() {
        if (loginManager == null) {
            loginManager = new LoginManager();
        }
        return loginManager;
    }
    
    // 사용 중인지 확인
    public boolean isUsing(String userId) {
        return loginUsers.containsKey(userId);
    }

    // 사용자 추가
    public void addUser(String userId, String sessionId) {
        loginUsers.put(userId, sessionId);
    }

    // 사용자 제거
    public void removeUser(String sessionId) {
        List<String> userIdList = new ArrayList<>(loginUsers.keySet());
        for (String id : userIdList) {
            String sid = loginUsers.get(id);
            if (sessionId.equals(sid)) {
                loginUsers.remove(id);
            }
        }
    }

    // sessionId로 userId 조회
    public String getUserId(String sessionId) {
        List<String> userIdList = new ArrayList<>(loginUsers.keySet());
        System.out.println("접속자 수 : " + userIdList.size());

        for (String userId : userIdList) {
            String storedSessionId = loginUsers.get(userId);
            System.out.println(userId + " : " + storedSessionId);

            if (sessionId.equals(storedSessionId)) {
                return userId;
            }
        }
        return null;
    }
}
