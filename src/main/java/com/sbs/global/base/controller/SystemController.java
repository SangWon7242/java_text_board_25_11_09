package com.sbs.global.base.controller;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.global.base.container.Container;
import com.sbs.global.base.rq.Rq;

import java.util.Scanner;

public class SystemController {

  public void run() {
    Scanner sc = Container.sc;
    Rq rq = new Rq();

    System.out.println("== 자바 게시판 시작 ==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine().trim();

      rq.setCommand(cmd);
      rq.getActionPath();

      if(cmd.trim().isEmpty()) {
        System.out.println("명령어를 입력해주세요.");
        continue;
      }

      if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        System.out.println("== 자바 게시판 종료 ==");

        sc.close();
        break;
      }

      if(!rq.getUrlPathUserType().startsWith("usr")) {
        System.out.println("명령어를 확인 후 다시 입력해주세요.");
        return;
      }
      
      BaseController baseController = getControllerByRequestUri(rq);

      if(baseController != null) {
        baseController.doAction(rq);
      }

    }
  }

  private BaseController getControllerByRequestUri(Rq rq) {
    switch (rq.getUrlPathUserType()) {
      case "usr" -> {
        switch (rq.getUrlPathControllerName()) {
          case "article" -> {
            return Container.articleController;
          }
        }
      }
    }

    return null;
  }
}