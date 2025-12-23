package shop.service;

import shop.DAO.UserDAO;
import shop.DTO.Users;

/**
 * UserServiceImpl
 * - 비즈니스 로직 담당
 * - DAO와 Servlet 사이에서 흐름 제어
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();
    // DAO 객체 생성
    // DB 관련 작업은 전부 userDAO에게 위임

    @Override
    public int signup(Users user) {

        // 1. 비즈니스 로직 처리
        user.setEnabled(true);

        // 2. 실제 DB 저장은 DAO에게 위임
        int result = userDAO.signup(user);

        return result;   // 🔥 이 줄이 빠져 있었음
    }
}
