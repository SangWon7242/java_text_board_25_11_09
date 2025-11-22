package com.sbs.domain.member.service;

import com.sbs.domain.member.member.dto.Member;
import com.sbs.domain.member.repository.MemberRepository;
import com.sbs.global.base.container.Container;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }

  public Member join(String username, String password, String name) {
    return memberRepository.join(username, password, name);
  }
}
