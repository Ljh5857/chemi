package com.chemi.member.controller;

import com.chemi.member.service.MemberService;
import com.chemi.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("user")
public class MemberController {

  private final MemberService service;

  @GetMapping("addUser")
  public String addUser() {
    return "home/main";
  }

  @PostMapping("addUser")
  public int join(MemberVo vo) throws Exception {
    System.out.println("vo = " + vo);
    int result = service.join(vo);
    System.out.println("result = " + result);
    return result;
  }

  @GetMapping("login")
  public String login(){
    return "user/login";
  }
  @PostMapping("login")
  public String login(MemberVo vo, HttpSession ss) {
    String loginResult = service.login(vo);
    System.out.println("MemberController.login");
    if ("success".equals(loginResult)) {
      ss.setAttribute("member", vo);
      return "redirect:/home"; // 로그인 성공 시 리다이렉트할 페이지
    }
    System.out.println("vo = " + vo);
    System.out.println("loginResult = " + loginResult);
    return "redirect:/login?error"; // 로그인 실패 시 리다이렉트할 페이지
  }

  @GetMapping("selectId")
  public MemberVo selectId(MemberVo vo) {
    return service.selectId(vo);
  }

  @GetMapping("selectPwd")
  public MemberVo selectPwd(MemberVo vo) {
    return service.selectPwd(vo);
  }

  @PutMapping("changePwd")
  public String changePwd(@RequestBody MemberVo vo) {
    return service.changePwd(vo);
  }

  @PostMapping("delUser")
  public ResponseEntity<String> delUser(@RequestBody MemberVo vo) {

    int result = service.delUser(vo);

    if(result != 1){
      throw new RuntimeException();
    }

    return ResponseEntity.ok("회원탈퇴 성공");

  }

  @GetMapping("myPage")
  public String myPage(@RequestBody MemberVo vo) {
    return service.myPage(vo);
  }
}
