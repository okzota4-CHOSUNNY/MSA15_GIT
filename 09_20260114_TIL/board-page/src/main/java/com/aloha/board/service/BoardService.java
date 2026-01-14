package com.aloha.board.service;

import java.util.List;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Pagination;

public interface BoardService {
  // 게시글 목록
  List<Board> list() throws Exception;
  // 페이징 목록 ⚡
  List<Board> page(Pagination pagination) throws Exception;
  // 게시글 조회
  Board select(Integer no) throws Exception;
  // 게시글 등록
  boolean insert(Board board) throws Exception;
  // 게시글 수정
  boolean update(Board board) throws Exception;
  // 게시글 삭제
  boolean delete(Integer no) throws Exception;
}