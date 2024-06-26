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

    //내 캠핑장 등록하기 (화면)
    @GetMapping("camp/insert")
    public String insertCamp(){
        return "owner/camping/insert";
    }

    //내 캠핑장 등록하기
    @PostMapping("camp/insert")
    public String insertCamp(CampingVo vo){
        int result = service.insertCamp(vo);
        return "";
    }


    //내 캠핑장 정보(화면)
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
    @PostMapping("camping")
    public String editCamp(HttpServletRequest req , CampingVo vo) throws Exception {
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String ownerNo = loginOwnerVo.getNo();
        String tel = req.getParameter("tel");
        int result = service.editCamp(tel , ownerNo);

        if(result != 1){
            throw new Exception("정보수정에 실패하였습니다.");
        }
        return "owner/OwnerMain";

    }

    //주요시설 정보 업데이트(화면)
    //주요시설 정보 업데이트(처리)

    //주요시설 정보 수정(화면)
    @GetMapping("facility")
    public String facilityView(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        CampingVo campVo = service.getCampByNo(no);
        model.addAttribute("campVo" , campVo);
        return "owner/facility";
    }

    //주요시설 정보 수정(처리)

    //캠핑장 일정 관리(캘린더api)



}