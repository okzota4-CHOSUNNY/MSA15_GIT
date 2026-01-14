package com.aloha.board.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {
  private Integer no;
  private String id;
  private String title;
  private String writer;
  private String content;
  private Date createdAt;
  private Date updatedAt;

  // 업로드 파일 목록 ⚡
  private List<MultipartFile> files;

  // 저장된 파일 목록 ⚡
  private List<Files> fileList;
  
  // 메인 파일 ⚡
  private Files mainFile;
  
  public Board() {
    this.id = UUID.randomUUID().toString();
  }

}