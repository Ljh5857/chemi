package com.chemi.owner.controller;

import com.chemi.owner.service.CampNoticeService;
import com.chemi.owner.vo.CampNoticeVo;
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
public class CampNoticeController {

    private final CampNoticeService service;


    //캠핑장 공지사항 리스트
    @GetMapping("notice/list")
    public String getCampNotice(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        List<CampNoticeVo> campNoticeList = service.getCampNotice(no);
        model.addAttribute("campNoticeList" , campNoticeList);
        return "owner/notice/list";
    }

    //캠핑장 공지사항 작성하기 (화면)
    @GetMapping("notice/insert")
    public String insertNotice(){
        return "owner/notice/insert";
    }

    //캠핑장 공지사항 작성하기 (처리)
    @PostMapping("notice/insert")
    public String insertNotice(HttpServletRequest req , CampNoticeVo vo) throws Exception {
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String ownerNo = loginOwnerVo.getNo();
        int result = service.insertNotice(vo);

        if(result != 1){
            throw new Exception("작성이 실패하였습니다.");
        }

        return "owner/notice/list";
    }

    //캠핑장 공지사항 상세화면
    @GetMapping("notice/detail")
    public String noticeDetail(HttpServletRequest req, Model model){
        String no = req.getParameter("no");
        CampingVo vo = service.noticeByNo(no);
        model.addAttribute("vo", vo);
        return "owner/notice/detail";
    }

    //캠핑장 공지사항 수정하기 (화면)

    //캠핑장 공지사항 수정하기 (처리)

}
