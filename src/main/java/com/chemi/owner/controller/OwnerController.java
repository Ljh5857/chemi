package com.chemi.owner.controller;

import com.chemi.owner.service.OwnerService;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService service;

    //로그인
    @PostMapping("login")
    public String login(OwnerVo vo , HttpServletRequest req){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = service.login(vo);
        session.setAttribute("alertMsg", vo.getName() + "님 환영합니다 ~~!!");
        session.setAttribute("loginOwnerVo" , loginOwnerVo);
        return "home";
    }
    //회원가입
    @PostMapping("join")
    public String join(OwnerVo vo) throws Exception {
        int result = service.join(vo);
        return "owner/login";
    }
    //비밀번호 변경 (화면)
    @GetMapping("edit")
    public String edit(HttpServletRequest req){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");

        String id = loginOwnerVo.getId();
        String pwd = loginOwnerVo.getPwd();
        String nick = loginOwnerVo.getNick();
        String phone = loginOwnerVo.getPhone();
        String address = loginOwnerVo.getAddress();
        String zipCode = loginOwnerVo.getZipCode();

        session.setAttribute("id" , id);
        session.setAttribute("pwd", pwd);
        session.setAttribute("nick" , nick);
        session.setAttribute("phone" , phone);
        session.setAttribute("address" , address);
        session.setAttribute("zopCode" , zipCode);

        return "edit";
    }

    //비밀번호 변경
    @PostMapping
    public String pwdEdit(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();

        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd2");

        OwnerVo vo = new OwnerVo();
        vo.setNo(no);
        vo.setPwd(pwd);
        vo.setPwd2(pwd2);

        int result = service.pwdEdit(vo);
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
