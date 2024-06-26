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
    System.out.println("MemberDao.login");
    return mapper.login(vo);
  }

  public MemberVo selectId(MemberVo vo) {

    return mapper.selectId(vo);
  }

  public MemberVo selectPwd(MemberVo vo) {

    return mapper.selectPwd(vo);
  }

  public int changePwd(MemberVo vo) {
    return mapper.changePwd(vo);
  }

  public int delUser(MemberVo vo) {
    return mapper.delUser(vo);
  }

  public String myPage(MemberVo vo) {

    return mapper.myPage(vo);
  }
}
