package com.aloha.spring_aop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring_aop.dto.Board;
import com.aloha.spring_aop.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {

  private final BoardService boardService;

  public HomeController(BoardService boardService) {
    this.boardService = boardService;
  }
  
  @RequestMapping(value = "/", method=RequestMethod.GET)
  public String home() {
    // 게시글 목록 요청
    List<Board> boardList = null;
    try {
      boardList = boardService.list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // 게시글 조회 요청
    Board board = null;
    try {
      board = boardService.select(1L);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "index";
  }
  
}