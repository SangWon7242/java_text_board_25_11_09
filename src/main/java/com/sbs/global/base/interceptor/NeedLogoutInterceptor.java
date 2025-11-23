package com.sbs.global.base.interceptor;

import com.sbs.global.base.rq.Rq;

public class NeedLogoutInterceptor implements Interceptor {
  @Override
  public boolean run(Rq rq) {
    if (rq.isLogout()) return true;

    return switch (rq.getActionPath()) {
      case "/usr/member/login",
           "/usr/member/join" -> {
        System.out.println("로그아웃 후 이용해주세요.");
        yield false;
      }

      default -> true;
    };
  }
}

