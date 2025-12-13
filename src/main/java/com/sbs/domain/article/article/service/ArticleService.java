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

  public Article write(String title, String content, int writerId, String writerName) {
    return articleRepository.write(title, content, writerId, writerName);
  }

  public List<Article> getArticles() {
    return articleRepository.findAll();
  }

  public List<Article> getArticles(String keyword, String sortCode) {
    // 검색 수행
    List<Article> filteredArticles = getFilteredArticles(keyword);

    // 정렬 수행
    return sortedArticles(filteredArticles, sortCode);
  }

  private List<Article> sortedArticles(List<Article> articles, String sortCode) {
    // 복사본을 생성
    List<Article> sortedArticles = new ArrayList<>(articles);

    if (!sortCode.isEmpty()) {
      switch (sortCode) {
        case "idAsc":
          sortedArticles.sort((a1, a2) -> a1.getId() - a2.getId());
          break;
        case "idDesc":
        default:
          sortedArticles.sort((a1, a2) -> a2.getId() - a1.getId());
          break;
      }
    }

    return sortedArticles;
  }

  private List<Article> getFilteredArticles(String keyword) {
    return articleRepository.findByKeywordContaining(keyword);
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
