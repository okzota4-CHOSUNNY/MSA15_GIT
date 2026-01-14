package com.aloha.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Files;
import com.aloha.board.dto.Pagination;
import com.aloha.board.dto.ParentTable;
import com.aloha.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;
  private final FileService fileService;

  @Override
  public List<Board> list() throws Exception {
    List<Board> list = boardMapper.list();
    return list;
  }

  @Override
  public Board select(Integer no) throws Exception {
    Board board = boardMapper.select(no);
    return board;
  }

  @Override
  public boolean insert(Board board) throws Exception {
    // 게시글 등록
    int result = boardMapper.insert(board);
    int parentNo = board.getNo();

    // 파일 업로드
    int fileResult = fileService.upload(board.getFiles(), ParentTable.BOARD, parentNo);
    log.info("파일 업로드 - {}개 파일 등록", fileResult);
    return result > 0;
  }
  
  @Override
  public boolean update(Board board) throws Exception {
    // 게시글 수정
    int result = boardMapper.update(board);

    // 파일 업로드
    int parentNo = board.getNo();
    int fileResult = fileService.upload(board.getFiles(), ParentTable.BOARD, parentNo);
    log.info("파일 업로드 - {}개 파일 등록", fileResult);
    return result > 0;
  }
  
  @Override
  @Transactional    
  // 트랜잭션 처리 : 2개 이상의 데이터베이스 요청에서
  //                하나라도 실패하면 전체를 롤백한다.
  public boolean delete(Integer no) throws Exception {
    // 게시글 삭제
    int result = boardMapper.delete(no);
    // 첨부파일 삭제
    Files file = new Files();
    file.setParentTable(ParentTable.BOARD.value());
    file.setParentNo(no);
    int fileResult = fileService.deleteByParent(file);
    log.info("파일 삭제 - {}개 파일 삭제", fileResult);
    return result > 0;
  }

  @Override
  public List<Board> page(Pagination pagination) throws Exception {
    // 데이터 수 조회
    long total = boardMapper.count();
    pagination.setTotal(total);
    List<Board> list = boardMapper.page(pagination);
    return list;
  }
  
}