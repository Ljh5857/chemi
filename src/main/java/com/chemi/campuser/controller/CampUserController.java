package com.chemi.campuser.controller;

import com.chemi.campuser.service.CampUserService;
import com.chemi.campuser.vo.*;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Camp")
public class CampUserController {

    private final CampUserService service;

    //캠핑장 목록조회(캠핑장 데이터만)
    @GetMapping
    public List<CampSiteVo> getCampList(){

        List<CampSiteVo> campSiteList = service.getCampSiteList();
        System.out.println("campSiteList = " + campSiteList);

    return campSiteList;


}

    //캠핑장 이름으로 검색
    @GetMapping("campName")
    public List<CampSiteVo> campNameSelect(@RequestParam("name") String name){

        List<CampSiteVo> campSiteVoList = service.campNameSelect(name);
        System.out.println("campSiteVoList = " + campSiteVoList);
        return campSiteVoList;
    }

    @GetMapping("Detail")
    public CampDetailVo campDetail(@RequestParam("ownerNo") String ownerNo) {
        List<CampImgVo> campImgVoList = service.getCampImgList(ownerNo);

        List<CampNoticeVo> campNoticeVoList = service.getCampNoticeList(ownerNo);
        List<RefundVo> refundVoList = service.getRefundList(ownerNo);
//        List<SeasonVo> seasonVoList = service.getSeasonList(ownerNo);
        List<CampZoneVo> campZoneVoList = service.getCampZoneList(ownerNo);

        CampDetailVo detailVo = new CampDetailVo();

        detailVo.setCampImgVoList(campImgVoList);

        detailVo.setCampNoticeVoList(campNoticeVoList);
        detailVo.setRefundVoList(refundVoList);
//        detailVo.setSeasonVoList(seasonVoList);
        detailVo.setCampZoneVoList(campZoneVoList);
        System.out.println("detailVo = " + detailVo);
        return detailVo;
    }


}
