package com.sbs.global.base.container;

import com.sbs.domain.article.article.controller.ArticleController;
import com.sbs.domain.article.article.repository.ArticleRepository;
import com.sbs.domain.article.article.service.ArticleService;
import com.sbs.domain.member.controller.MemberController;
import com.sbs.domain.member.repository.MemberRepository;
import com.sbs.domain.member.service.MemberService;
import com.sbs.global.base.interceptor.NeedLoginInterceptor;
import com.sbs.global.base.interceptor.NeedLogoutInterceptor;
import com.sbs.global.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static NeedLoginInterceptor needLoginInterceptor;
  public static NeedLogoutInterceptor needLogoutInterceptor;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
