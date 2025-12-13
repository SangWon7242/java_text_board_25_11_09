package com.sbs.domain.article.article.service;

import com.sbs.domain.article.article.dto.Article;
import com.sbs.domain.article.article.repository.ArticleRepository;
import com.sbs.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public Article write(String title, String content, int writerId, String writerName, int boardId) {
    return articleRepository.write(title, content, writerId, writerName, boardId);
  }

  public List<Article> getArticles() {
    return articleRepository.findAll();
  }

  public List<Article> getArticles(String keyword, String sortCode, int boardId) {
    List<Article> articles = articleRepository.findAll();

    // 1. 게시판 필터링 (가장 먼저 - 데이터 양 감소)
    articles = getBoardArticles(articles, boardId);

    // 2. 키워드 필터링
    articles = getFilteredArticles(articles, keyword);

    // 3. 정렬
    articles = getSortedArticles(articles, sortCode);

    // 정렬 수행
    return articles;
  }

  private List<Article> getSortedArticles(List<Article> articles, String sortCode) {

    // 복사본을 생성
    List<Article> sorted = new ArrayList<>(articles);

    if (!sortCode.isEmpty()) {
      switch (sortCode) {
        case "idAsc":
          sorted.sort((a1, a2) -> a1.getId() - a2.getId());
          break;
        case "idDesc":
        default:
          sorted.sort((a1, a2) -> a2.getId() - a1.getId());
          break;
      }
    }

    return sorted;
  }

  private List<Article> getBoardArticles(List<Article> articles, int boardId) {
    return articleRepository.findByBoardId(articles, boardId);
  }

  private List<Article> getFilteredArticles(List<Article> articles, String keyword) {
    return articleRepository.findByKeywordContaining(articles, keyword);
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }

  public void modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);
  }

  public void delete(int id) {
    articleRepository.delete(id);
  }
}
