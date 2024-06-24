package com.chemi.member.dao;

import com.chemi.member.mapper.MemberMapper;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

  private final MemberMapper mapper;

  public int join(MemberVo vo) {
    return mapper.join(vo);
  }

  public String login(MemberVo vo) {

    return mapper.login(vo);
  }
}