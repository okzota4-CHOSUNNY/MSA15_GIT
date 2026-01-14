package com.aloha.board.dto;

public enum ParentTable {
  BOARD("board"),
  USER("user")
  // TODO
  // ....
  ;

  private final String tableName;

  ParentTable(String tableName) {
    this.tableName = tableName;
  }

  public String value() {
    return tableName;
  }
  
}