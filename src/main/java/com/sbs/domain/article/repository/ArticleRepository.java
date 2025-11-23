package com.sbs.domain.article.repository;

import com.sbs.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articles;

  public ArticleRepository() {
    articles = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> write("제목" + i, "내용" + i, 1, "user1")
        );
  }

  public Article write(String title, String content, int memberId, String writerName) {
    Article article = new Article(title, content, memberId, writerName);
    articles.add(article);

    return article;
  }

  public List<Article> findByAll() {
    return articles;
  }

  public Article findById(int id) {
    return articles.stream()
        .filter(article -> article.getId() == id)
        .findFirst().orElse(null);
  }

  public void modify(int id, String title, String content) {
    Article article = findById(id);

    if(article == null) return;

    article.setTitle(title);
    article.setContent(content);
  }

  public void delete(int id) {
    Article article = findById(id);

    if(article == null) return;

    articles.remove(article);
  }
}
