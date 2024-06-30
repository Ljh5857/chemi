package com.chemi.member.controller;


import com.chemi.member.service.Member.CheckMemberService;
import com.chemi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CheckMemberController {

    private final CheckMemberService chservice;

    public String checkId(MemberVo vo){

        return chservice.checkId(vo);
    }

}
