package com.sbs.domain.article.Board.repository;

import com.sbs.domain.article.Board.dto.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
  private List<Board> boards;

  public BoardRepository() {
    boards = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    boards.add(new Board("자유", "free"));
    boards.add(new Board("공지", "notice"));
  }

  public Board findByBoardId(int id) {
    return boards.stream()
        .filter(Board -> Board.getId() == id)
        .findFirst().orElse(null);
  }
}
