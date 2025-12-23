package board.DTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.DAO.DesignerVO;

public class DesignerDAO {
    // DB 연결 정보 (본인꺼로 확인 필수!)
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String uid = "scott"; 
    private String upw = "tiger";

    private Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, uid, upw);
    }

    // 1. 디자이너 목록 가져오기
    public List<DesignerVO> getDesignerList() {
        List<DesignerVO> list = new ArrayList<>();
        String sql = "SELECT * FROM DESIGNER ORDER BY ID ASC";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while(rs.next()) {
                DesignerVO vo = new DesignerVO();
                vo.setId(rs.getInt("ID"));
                vo.setName(rs.getString("NAME"));
                vo.setInfo(rs.getString("INFO"));
                vo.setReviewCnt(rs.getInt("REVIEW_CNT"));
                vo.setImgUrl(rs.getString("IMG_URL"));
                list.add(vo);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
    // 2. 디자이너 한 명 상세 정보 가져오기 (상세페이지용)
    public DesignerVO getDesigner(int id) {
        DesignerVO vo = new DesignerVO();
        String sql = "SELECT * FROM DESIGNER WHERE ID = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    vo.setId(rs.getInt("ID"));
                    vo.setName(rs.getString("NAME"));
                    vo.setInfo(rs.getString("INFO"));
                    vo.setCareer(rs.getString("CAREER")); // 경력 추가
                    vo.setReviewCnt(rs.getInt("REVIEW_CNT"));
                    vo.setImgUrl(rs.getString("IMG_URL"));
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return vo;
    }
}