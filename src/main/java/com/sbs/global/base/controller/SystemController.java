package com.sbs.global.base.controller;

import com.sbs.domain.article.controller.ArticleController;

import java.util.Scanner;

public class SystemController {
  private ArticleController articleController;

  public SystemController() {
    articleController = new ArticleController();
  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("== 자바 게시판 시작 ==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        System.out.println("== 자바 게시판 종료 ==");
        break;
      }

      String[] urlBits = cmd.trim().split("/");

      String urlPathUserType = urlBits[1];
      String urlPathUserResource = urlBits[2];
      String urlPathUserAction = urlBits[3];

      String urlPathVariable = null;

      if (urlBits.length > 4) {
        urlPathVariable = urlBits[4];
      }

      switch (urlPathUserType) {
        case "usr" -> {
          switch (urlPathUserResource) {
            case "article" -> {
              switch (urlPathUserAction) {
                case "write" -> articleController.doWrite();
                case "detail" -> articleController.showDetail(urlPathVariable);
                case "list" -> articleController.showList();
              }
            }
          }
        }
      }
    }
  }
}