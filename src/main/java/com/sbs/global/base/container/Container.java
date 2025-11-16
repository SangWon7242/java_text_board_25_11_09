package com.sbs.global.base.container;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.dto.Article;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    articleController = new ArticleController();
  }
}
