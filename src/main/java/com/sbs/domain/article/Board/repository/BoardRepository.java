package com.sbs.domain.article.Board.repository;

import com.sbs.domain.article.Board.dto.Board;
import com.sbs.global.util.Ut;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
  private List<Board> boards;

  public BoardRepository() {
    boards = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    add("자유", "free");
    add("공지", "notice");
  }

  public Board findByBoardId(int id) {
    return boards.stream()
        .filter(Board -> Board.getId() == id)
        .findFirst().orElse(null);
  }

  public Board findByBoardName(String boardName) {
    return boards.stream()
        .filter(board -> board.getName().equals(boardName))
        .findFirst()
        .orElse(null);
  }

  public Board findByBoardCode(String boardCode) {
    return boards.stream()
        .filter(board -> board.getCode().equals(boardCode))
        .findFirst()
        .orElse(null);
  }

  public void add(String name, String code) {
    String regDate = Ut.getNowDateStr();
    String updateDate = Ut.getNowDateStr();

    Board board = new Board(regDate, updateDate, name, code);

    boards.add(board);
  }
}
