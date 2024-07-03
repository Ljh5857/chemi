package com.chemi.campuser.controller;

import com.chemi.campuser.service.CampUserService;
import com.chemi.owner.vo.CampDetailVo;
import com.chemi.owner.vo.CampImgVo;
import com.chemi.owner.vo.CampingVo;
import com.chemi.owner.vo.ZoneVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("Camp")
public class CampUserController {

    private final CampUserService service;

    //캠핑장 목록조회(캠핑장 데이터만)
    @GetMapping
    public List<CampingVo> CampList(){

        List<CampingVo> CampingVoList = service.CampList();

    return CampingVoList;


}

    //캠핑장 이름으로 검색
    @GetMapping()
    public List<CampingVo> campNameSelect(){

        List<CampingVo> CampingVoList = service.campNameSelect();

        return CampingVoList;
    }

    //캠핑장 상세조회(캠핑장 이미지까지)
    @GetMapping("Detail")
    public CampDetailVo campimgList(@RequestParam String campNo) {
        CampingVo campingVo = service.getCampingDetail(campNo);
        List<CampImgVo> campImgVoList = service.getCampImgList(campNo);

        CampDetailVo detailVo = new CampDetailVo();
        detailVo.setCampingVo(campingVo);
        detailVo.setCampImgVoList(campImgVoList);

        return detailVo;
    }


}
