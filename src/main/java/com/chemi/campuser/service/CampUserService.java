package com.chemi.campuser.service;

import com.chemi.campuser.dao.CampUserDao;
import com.chemi.campuser.vo.*;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CampUserService {

    private final CampUserDao dao;

    public List<CampImgVo> getCampImgList(String ownerNo) {
        return dao.getCampImgList(ownerNo);
    }

    public List<CampSiteVo> campNameSelect(String name) {
        return dao.campNameSelect(name);
    }

    public List<CampNoticeVo> getCampNoticeList(String ownerNo) {
        return dao.getCampNoticeList(ownerNo);
    }

//    public List<SeasonVo> getSeasonList(String ownerNo) {
//        return dao.getSeasonList(ownerNo);
//    }

    public List<RefundVo> getRefundList(String ownerNo) {
        return dao.getrefundList(ownerNo);
    }

    public List<CampSiteVo> getCampSiteList() {
        return dao.getCampSiteList();
    }

    public List<CampZoneVo> getCampZoneList(String ownerNo) {
        return dao.getCampZoneList(ownerNo);
    }


}
