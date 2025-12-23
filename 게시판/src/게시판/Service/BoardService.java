package 게시판.Service;

import java.util.List;

import 게시판.DTO.Board;

/**
 * 게시판 프로그램
 * - 게시글 목록
 * - 게시글 조회
 * - 게시글 등록
 * - 게시글 수정
 * - 게시글 삭제
 */
public interface BoardService {
	
	List<Board> list();
	Board select(int no);
	int insert(Board board);
	int update(Board board);
	int delete(int no);
	
}



