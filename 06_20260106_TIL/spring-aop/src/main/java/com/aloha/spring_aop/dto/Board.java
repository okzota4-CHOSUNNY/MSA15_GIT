package com.aloha.spring_aop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  private Long no;
  private String id;
  private String title;
  private String writer;
  private String content;
  private Date createdAt;
  private Date updatedAt;
  
}