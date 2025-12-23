package board.servlet;

import java.util.List;

import board.DTO.Board;

public interface Boardservice {
	// 게시글 목록
	List<Board> list();
	// 게시글 조회
	Board select(int no);
	Board selectById(String id);
	
}