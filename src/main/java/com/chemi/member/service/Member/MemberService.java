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

  public MemberVo selectId(MemberVo vo) {
    return dao.selectId(vo);
  }

  public MemberVo selectPwd(MemberVo vo) {
    return dao.selectPwd(vo);
  }

  public String changePwd(MemberVo vo) {

    int result = dao.changePwd(vo);

    if (result > 0) {
      return "비밀번호 변경 성공";
    }else {
      return "비밀번호 변경 실패";
    }
  }

  public String deluser(MemberVo vo) {

    int result = dao.deluser(vo);

    if (result > 0){
      return "회원탈퇴 성공";
    }else {
      return "회원탈퇴 실패";
    }

  }
}
