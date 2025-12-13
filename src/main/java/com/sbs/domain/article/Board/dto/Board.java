package com.sbs.domain.article.Board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // public Article(int id, String title, String content) {}
@NoArgsConstructor // public Article() {}
@ToString
public class Board {
  private static int lastId;
  private int id;
  private String name; // 공지사항, 자유
  private String code; // notice, free

  static {
    lastId = 0;
  }

  public Board(String name, String code) {
    this(++lastId, name, code);
  }
}
