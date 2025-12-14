package com.sbs.domain.article.Board.repository;

import com.sbs.domain.article.Board.dto.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    Board board = new Board(name, code);

    boards.add(board);
  }
}
