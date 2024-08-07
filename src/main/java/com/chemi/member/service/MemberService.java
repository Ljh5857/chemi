package com.chemi.member.service;

import com.chemi.member.dao.MemberDao;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberDao dao;

  public int join(MemberVo vo) throws Exception {

    // 유효성 검사
    if(vo.getId().length() < 4) {
      throw new Exception("아이디가 짧습니다. 최소 4글자이상.");
    }

    if(vo.getPwd().length() < 8) {
      throw new Exception("비밀번호 최소 8글자 이상 바랍니다.");
    }

    if(!vo.getPwd().equals(vo.getPwd2())) {
      throw new Exception("비밀번호가 일치하지 않습니다. 확인바랍니다.");
    }

    if(!isValidName(vo.getName())) {
      throw new Exception("이름은 한글만 가능합니다.");
    }

    if(!isValidPhone(vo.getPhone())) {
      throw new Exception("휴대폰 번호 형식이 올바르지 않습니다.");
    }

    if(!isValidEmail(vo.getEmail())) {
      throw new Exception("이메일 형식이 올바르지 않습니다.");
    }

    // 유효성 검사를 통과하면 DAO 호출
    System.out.println("service = " + vo);

    return dao.join(vo);
  }

  public String login(MemberVo vo) {
    System.out.println("MemberService.login");
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
    } else {
      return "비밀번호 변경 실패";
    }
  }

  public int delUser(MemberVo vo) {
    int result = dao.delUser(vo);

      return result;
  }

  public String myPage(MemberVo vo) {
    return dao.myPage(vo);
  }




  // 유효성 검사 메서드
  private boolean isValidName(String name) {
    return Pattern.matches("^[가-힣]*$", name);
  }


  private boolean isValidPhone(String phone) {
    return Pattern.matches("^\\d{11}$", phone);
  }

  private boolean isValidEmail(String email) {
    return Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", email);
  }


}