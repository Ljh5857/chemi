package com.chemi.owner.controller;

import com.chemi.owner.service.CampingService;
import com.chemi.owner.vo.CampingVo;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("owner")
@RequiredArgsConstructor
public class CampingController {

    private final CampingService service;

    //내 캠핑장 등록하기


    //내 캠핑장 정보 불러오기
    @GetMapping("camping")
    public String getCampListByNo(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        CampingVo voList = service.getCampByNo(no);
        model.addAttribute("voList" , voList);
        return "owner/camping";
    }
    //캠핑장 정보 수정

    //캠핑장 공지사항 불러오기
    @PostMapping("camping/notice")
    public void getCampNotice(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
//        List<> campNoticeList = service.getCampNotice(no);
    }
    //캠핑장 공지사항 작성하기

    //예약리스트

    //예약

}