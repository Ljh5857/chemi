package com.chemi.owner.controller;

import com.chemi.owner.vo.CampingVo;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class CampNoticeController {

    //캠핑장 공지사항 리스트
    @GetMapping("camping/notice/list")
    public void getCampNotice(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
//        List<CampingVo> campNoticeList = service.getCampNotice(no);
//        model.addAttribute("campNoticeList" , campNoticeList);
        return ;
    }
    //캠핑장 공지사항 작성하기 (화면)
    //캠핑장 공지사항 작성하기 (처리)
    //캠핑장 공지사항 수정하기 (화면)
    //캠핑장 공지사항 수정하기 (처리)

}
