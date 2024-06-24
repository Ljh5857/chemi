package com.chemi.member.service.Member;

import com.chemi.member.dao.MemberDao;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberDao dao;

  public int join(MemberVo vo) {

    System.out.println("service = " + vo);
    return dao.join(vo);

  }

  public String login(MemberVo vo) {

    return dao.login(vo);
  }
}
