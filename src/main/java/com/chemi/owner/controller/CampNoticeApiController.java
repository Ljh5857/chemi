package com.chemi.owner.controller;

import com.chemi.owner.service.CampNoticeService;
import com.chemi.owner.vo.CampNoticeVo;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("owner/api/notice")
@RequiredArgsConstructor
public class CampNoticeApiController {

    private final CampNoticeService service;

    @GetMapping("list")
    public List<CampNoticeVo> getNoticeList(HttpSession session){
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        List<CampNoticeVo> campNoticeList = service.getCampNotice(no);
        System.out.println("campNoticeList = " + campNoticeList);

        return campNoticeList;
    }

    //캠핑장 공지사항 작성하기 (처리)
    @PostMapping("insert")
    public String insertNotice(HttpSession session , CampNoticeVo vo){
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String ownerNo = loginOwnerVo.getNo();
        vo.setOwnerNo(ownerNo);

        int result = service.insertNotice(vo);

        if(result != 1){
            throw new RuntimeException("작성이 실패하였습니다.");
        }

        return "redirect:/owner/notice/list";
    }
}
