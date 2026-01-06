package com.aloha.spring_aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring_aop.dao.BoardDAO;
import com.aloha.spring_aop.dto.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardDAO boardDAO;

  @Override
  public List<Board> list() throws Exception {
    List<Board> list = boardDAO.list();
    int count = list.size();
    log.info("게시글 목록을 조회합니다...");
    log.info("게시글 개수 : {}", count);
    return list;
  }

  @Override
  public Board select(Long no) throws Exception {
    Board board = boardDAO.select(no);
    log.info("게시글을 조회합니다...");
    return board;
  }

  @Override
  public boolean insert(Board board) throws Exception {
    int result = boardDAO.insert(board);
    log.info("게시글 등록...");
    return result > 0;
  }

  @Override
  public boolean update(Board board) throws Exception {
    int result = boardDAO.update(board);
    log.info("게시글 수정...");
    return result > 0;
  }

  @Override
  public boolean delete(Long no) throws Exception {
    int result = boardDAO.delete(no);
    log.info("게시글 삭제...");
    return result > 0;
  }
  
}