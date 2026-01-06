package com.aloha.spring_aop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.aloha.spring_aop.dto.Board;

@Repository
public class BoardDAO {

  public List<Board> list() {
    List<Board> boardList = new ArrayList<>();
    String id1 = UUID.randomUUID().toString();
    String id2 = UUID.randomUUID().toString();
    String id3 = UUID.randomUUID().toString();
    boardList.add(new Board(1L, id1, 
                      "제목", "내용", "작성자", 
                      new Date(), new Date())
                  );
    boardList.add(new Board(2L, id2, 
                      "제목", "내용", "작성자", 
                      new Date(), new Date())
                  );
    boardList.add(new Board(3L, id3, 
                      "제목", "내용", "작성자", 
                      new Date(), new Date())
                  );
    return boardList;
  }

  public Board select(Long no) {
    String id = UUID.randomUUID().toString();
    return new Board(no, id, 
                    "제목", "내용", "작성자", 
                    new Date(), new Date());
  }

  public int insert(Board board) {
    int result = 0;
    return result;
  }

  public int update(Board board) {
    int result = 0;
    return result;
  }

  public int delete(Long no) {
    int result = 0;
    return result;
  }
  
}