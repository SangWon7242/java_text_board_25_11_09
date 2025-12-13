package com.sbs.domain.article.Board.service;

import com.sbs.domain.article.Board.dto.Board;
import com.sbs.domain.article.Board.repository.BoardRepository;
import com.sbs.global.base.container.Container;

public class BoardService {
  private BoardRepository boardRepository;

  public BoardService() {
    boardRepository = Container.boardRepository;
  }

  public Board findByBoardId(int id) {
    return boardRepository.findByBoardId(id);
  }
}
