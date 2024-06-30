package com.chemi.owner.controller;

import com.chemi.owner.service.OwnerService;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping("main")
    public String mainPage(){

        return "owner/ownerMain";
    }

    //로그인 (화면)
    @GetMapping("login")
    public String login(){
        return "owner/login";
    }
    //로그인
    @PostMapping("login")
    public String login(OwnerVo vo , HttpServletRequest req){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = service.login(vo);

        if(loginOwnerVo != null){
            session.setAttribute("loginOwnerVo" , loginOwnerVo);
            session.setAttribute("alertMsg", vo.getName() + "님 환영합니다 ~~!!");
            return "owner/OwnerMain";
        }else{
            req.setAttribute("errMsg" , "로그인 실패...");
            return "owner/login";
        }
    }
    //회원가입(화면)
    @GetMapping("join")
    public String join(){
        return "owner/join";
    }
    //회원가입
    @PostMapping("join")
    public String join(OwnerVo vo) throws Exception {
        int result = service.join(vo);
        if(result != 1){
            throw new Exception("회원가입 실패...");
        }
        return "owner/login";

    }
    //비밀번호 변경 (화면)
    @GetMapping("edit")
    public String edit(HttpServletRequest req , Model model) throws Exception {
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        if(loginOwnerVo == null){
            throw new Exception("로그인 후 이용 가능합니다.");
        }
        return "edit";
    }

    //개인정보 변경
    @PostMapping("edit")
    public String pwdEdit(HttpServletRequest req , OwnerVo vo ) throws Exception {
        HttpSession session = req.getSession();

        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();

        int result = service.pwdEdit(vo);

        if(result != 1){
            throw new Exception("정보수정에 실패하였습니다.");
        }
        session.setAttribute("alertMsg" , "회원정보 수정 성공 ~!");
        session.removeAttribute("loginOwnerVo");
        return "home";
    }
    //로그아웃
    @GetMapping("logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.invalidate();
        return "home";
    }



}
