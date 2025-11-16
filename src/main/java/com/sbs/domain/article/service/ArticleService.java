package com.sbs.domain.article.service;

import com.sbs.domain.article.dto.Article;
import com.sbs.domain.article.repository.ArticleRepository;
import com.sbs.global.base.container.Container;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public Article write(String title, String content) {
    return articleRepository.write(title, content);
  }

  public List<Article> getArticles() {
    return articleRepository.findByAll();
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }
}
