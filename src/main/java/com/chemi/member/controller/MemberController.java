package com.chemi.member.controller;

import com.chemi.member.service.Member.MemberService;
import com.chemi.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
@RequestMapping("user")
public class MemberController {

  
  private final MemberService service;

  @GetMapping("addUser")
  public String addUser() {

    return "user/addGeneralUser";
  }


@PostMapping("addUser")
public int join(MemberVo vo){

  System.out.println("vo = " + vo);
  int result = service.join(vo);
  System.out.println("result = " + result);
  return result;

}
@GetMapping("login")
public String login(@RequestBody MemberVo vo, HttpSession ss){
  String loginResult = service.login(vo);

  if ("success".equals(loginResult)){
    ss.setAttribute("member",vo);
  }

  return loginResult;


}

@GetMapping("selectId")
public MemberVo selectId(MemberVo vo){

  return service.selectId(vo);
}

@GetMapping("selectPwd")
public MemberVo selectPwd(MemberVo vo){

  return service.selectPwd(vo);
}
@PutMapping("changePwd")
public String changePwd(@RequestBody MemberVo vo){

  return service.changePwd(vo);
}

@PostMapping("delUser")
  public String delUser(MemberVo vo){

    return service.delUser(vo);
}


@GetMapping("myPage")
  public String myPage(MemberVo vo){

    return service.myPage(vo);
}

}
