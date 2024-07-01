package com.chemi.owner.controller;

import com.chemi.owner.service.CampNoticeService;
import com.chemi.owner.vo.CampNoticeVo;
import com.chemi.owner.vo.CampingVo;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("owner/notice")
@RequiredArgsConstructor
public class CampNoticeController {

    private final CampNoticeService service;


    //캠핑장 공지사항 리스트
    @GetMapping("list")
    public String getCampNotice(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        List<CampNoticeVo> campNoticeList = service.getCampNotice(no);
        model.addAttribute("campNoticeList" , campNoticeList);
        return "owner/noticeList";
    }

    //캠핑장 공지사항 작성하기 (화면)
    @GetMapping("insert")
    public String insertNotice(){
        return "owner/noticeInsert";
    }

    //캠핑장 공지사항 작성하기 (처리)
    @PostMapping("insert")
    public String insertNotice(HttpSession session , CampNoticeVo vo){
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String ownerNo = loginOwnerVo.getNo();



        int result = service.insertNotice(vo);

        if(result != 1){
            throw new RuntimeException("작성이 실패하였습니다.");
        }

        return "owner/notice/list";
    }

    //캠핑장 공지사항 상세화면 (화면)
    @GetMapping("detail")
    public String noticeDetail(String no, Model model){
        CampNoticeVo vo = service.noticeDetail(no);
        model.addAttribute("vo" ,vo);
        return "owner/notice/detail";
    }


    //캠핑장 공지사항 수정하기 (화면)
    @GetMapping("edit")
    public String edit(){
        return "owner/notice/edit";
    }

    //캠핑장 공지사항 수정하기 (처리)
    @PostMapping("edit")
    public String edit(CampNoticeVo vo){
        int result = service.edit(vo);

        if(result != 1){
            throw new RuntimeException();
        }

        return "notice/list";
    }
}
