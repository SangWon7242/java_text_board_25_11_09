package com.sbs.domain.article.article.repository;

import com.sbs.domain.article.article.dto.Article;
import com.sbs.global.util.Ut;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
            i -> write("제목" + i, "내용" + i, 2, "user1", 1)
        );
  }

  public Article write(String title, String content, int memberId, String writerName, int boardId) {
    String regDate = Ut.getNowDateStr();
    String updateDate = Ut.getNowDateStr();

    Article article = new Article(regDate, updateDate, title, content, memberId, writerName, boardId);
    articles.add(article);

    return article;
  }

  public List<Article> findAll() {
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

    String updateDate = Ut.getNowDateStr();

    article.setUpdateDate(updateDate);
    article.setTitle(title);
    article.setContent(content);
  }

  public void delete(int id) {
    Article article = findById(id);

    if(article == null) return;

    articles.remove(article);
  }

  public List<Article> findByKeywordContaining(List<Article> articles, String keyword) {
    if(keyword.isEmpty()) return articles;

    return articles.stream()
        .filter(article -> article.getTitle().contains(keyword) || article.getContent().contains(keyword))
        .collect(Collectors.toList());
  }

  public List<Article> findByBoardId(List<Article> articles, int boardId) {
    return articles.stream()
        .filter(article -> article.getBoardId() == boardId)
        .collect(Collectors.toList());
  }
}
