package com.sbs.domain.member.controller;

import com.sbs.domain.member.member.dto.Member;
import com.sbs.domain.member.service.MemberService;
import com.sbs.global.base.container.Container;
import com.sbs.global.base.controller.BaseController;
import com.sbs.global.base.rq.Rq;

public class MemberController implements BaseController {
  private MemberService memberService;

  public MemberController() {
    memberService = Container.memberService;
  }

  @Override
  public void doAction(Rq rq) {
    switch (rq.getUrlPathUserAction()) {
      case "join" -> doJoin();
      case "login" -> doLogin();
    }
  }

  private void doLogin() {
    String username;
    String password;
    Member member;

    System.out.println("== 로그인 ==");

    // 아이디 입력
    while (true) {
      System.out.print("아이디 : ");
      username = Container.sc.nextLine();

      member = memberService.findByUsername(username);

      if (member == null) {
        System.out.println("입력하신 아이디는 존재하지 않습니다.");
        continue;
      }

      if (username.trim().isEmpty()) {
        System.out.println("아이디를 입력해주세요.");
        continue;
      }

      break;
    }

    int tryMaxCount = 3;
    int tryCount = 0;

    // 비밀번호 입력
    while (true) {
      if(tryCount == tryMaxCount) {
        System.out.println("비밀번호를 확인 후 다시 입력해주세요.");
        break;
      }

      System.out.print("비밀번호 : ");
      password = Container.sc.nextLine();

      if (password.trim().isEmpty()) {
        System.out.println("비밀번호를 입력해주세요.");
        continue;
      }

      if (!member.getPassword().equals(password)) {
        ++tryCount;
        System.out.printf("비밀번호가 틀렸습니다. | 시도횟수(%d/%d)\n", tryCount, tryMaxCount);
        continue;
      }

      break;
    }

    System.out.printf("'%s'님 로그인 되었습니다.\n", member.getUsername());
  }

  private void doJoin() {
    String username;
    String password;
    String passwordConfirm;
    String name;
    Member oldMember;

    System.out.println("== 회원 가입 ==");

    // 아이디 입력
    while (true) {
      System.out.print("아이디 : ");
      username = Container.sc.nextLine();

      oldMember = memberService.findByUsername(username);

      if (oldMember != null) {
        System.out.println("이미 존재하는 아이디입니다.");
        continue;
      }

      if (username.trim().isEmpty()) {
        System.out.println("아이디를 입력해주세요.");
        continue;
      }

      break;
    }

    // 비밀번호 입력
    while (true) {
      System.out.print("비밀번호 : ");
      password = Container.sc.nextLine();

      if (password.trim().isEmpty()) {
        System.out.println("비밀번호를 입력해주세요.");
        continue;
      }

      while (true) {
        System.out.print("비밀번호 확인 : ");
        passwordConfirm = Container.sc.nextLine();

        if (passwordConfirm.trim().isEmpty()) {
          System.out.println("비밀번호 확인을 입력해주세요.");
          continue;
        }

        if (!passwordConfirm.equals(password)) {
          System.out.println("비밀번호가 일치하지 않습니다.");
          continue;
        }

        break;
      }

      break;
    }

    // 이름 입력
    while (true) {
      System.out.print("이름 : ");
      name = Container.sc.nextLine();

      if (name.trim().isEmpty()) {
        System.out.println("이름을 입력해주세요.");
        continue;
      }

      break;
    }

    Member member = memberService.join(username, password, name);

    System.out.printf("'%s'님 회원 가입 되었습니다.\n", member.getName());
  }
}


