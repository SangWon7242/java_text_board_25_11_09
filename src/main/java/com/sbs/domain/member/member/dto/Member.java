package com.sbs.domain.member.member.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
  private static int lastId;
  private int id;
  private String username;
  private String password;
  private String name;

  static {
    lastId = 0;
  }

  public Member(String username, String password, String name) {
    this(++lastId, username, password, name);
  }
}
