package com.chemi.member.controller;

import com.chemi.member.service.Member.MemberService;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("member")
public class MemberController {

  
  private final MemberService service;

//@GetMapping("join")
//public String join(){
//
//  return "member/join";
//
//}

@PostMapping("join")
@ResponseBody
public int join(MemberVo vo){

  System.out.println("vo = " + vo);
  int result = service.join(vo);
  System.out.println("result = " + result);
  return result;

}

public String login(MemberVo vo){

  return service.login(vo);

}
}
