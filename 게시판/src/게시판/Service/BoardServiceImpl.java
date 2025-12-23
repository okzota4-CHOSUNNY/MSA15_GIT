package 게시판.Service;

import java.util.List;

import 게시판.DAO.BoardDAO;
import 게시판.DTO.Board;

/**
 * 게시판 기능 - 비즈니스 로직 클래스
 */
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public List<Board> list() {
		List<Board> boardList = boardDAO.list();
		return boardList;
	}

	@Override
	public Board select(int no) {
		Board board = boardDAO.select(no);
		return board;
	}

	@Override
	public int insert(Board board) {
		int result = boardDAO.insert(board);
		if( result > 0 ) System.out.println("데이터 등록 성공!");
		else System.err.println("데이터 등록 실패!");
		return result;
	}

	@Override
	public int update(Board board) {
		int result = boardDAO.update(board);
		if( result > 0 ) System.out.println("데이터 수정 성공!");
		else System.err.println("데이터 수정 실패!");
		return result;
	}

	@Override
	public int delete(int no) {
		int result = boardDAO.delete(no);
		if( result > 0 ) System.out.println("데이터 삭제 성공!");
		else System.err.println("데이터 삭제 실패!");
		return result;
	}
	
	

}