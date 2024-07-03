package com.chemi.owner.controller;

import com.chemi.owner.service.ZoneService;
import com.chemi.owner.vo.OwnerVo;
import com.chemi.owner.vo.ZoneVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("owner/api/zone")
@RequiredArgsConstructor
public class ZoneApiController {

    private final ZoneService service;

    //캠핑존 등록(처리)
    @PostMapping
    public ResponseEntity<String> zoneInsert(HttpSession session , ZoneVo vo) throws Exception {
        OwnerVo ownerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String ownerNo = ownerVo.getNo();
        vo.setOwnerNo(ownerNo);

        int result = service.zoneInsert(vo);
        if(result != 1){
             return ResponseEntity.internalServerError().body("등록에 실패하였습니다.");
        }else {
            return ResponseEntity.ok("등록 되었습니다.");
        }

    }
    //캠핑존 리스트(화면)
    @GetMapping
    public List<ZoneVo> zoneList(HttpServletRequest req){
        HttpSession session = req.getSession();
        OwnerVo loginOwnerVo = (OwnerVo) session.getAttribute("loginOwnerVo");
        String no = loginOwnerVo.getNo();
        List<ZoneVo> voList= service.selectZone(no);
        return voList;

    }

}
