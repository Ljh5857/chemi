package com.chemi.owner.controller;

import com.chemi.owner.service.ZoneService;
import com.chemi.owner.vo.OwnerVo;
import com.chemi.owner.vo.ZoneVo;
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
public class ZoneController {

    private final ZoneService service;

    //캠핑존 리스트(화면)
    @GetMapping("zone/list")
    public String zoneList(HttpServletRequest req , Model model){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        List<ZoneVo> voList= service.selectZone(no);
        model.addAttribute("voList", voList);
        return "owner/zoneEdit";

    }
    //캠핑존 등록(화면)
    @GetMapping("zone/insert")
    public String zoneInsert(){
        return "owner/zoneInsert";
    }
    //캠핑존 등록(처리)
    @PostMapping("zone/insert")
    public String zoneInsert(ZoneVo vo) throws Exception {

        int result = service.zoneInsert(vo);

        if(result != 1){
            throw new Exception("등록에 실패했습니다.");
        }
        return "owner/ownerMain";
    }
    //캠핑존 수정(화면)
    @GetMapping("zone/edit")
    public String editZone(HttpServletRequest req , Model model){
        return "";
    }
    //캠핑존 수정(처리)
    @PostMapping("zone/edit")
    public String editZone(ZoneVo vo) throws Exception {
        int result = service.updateZone(vo);

        if(result != 1){
            throw new Exception("업데이트 불가...");
        }
        return "owner/zone/list";
    }
}
