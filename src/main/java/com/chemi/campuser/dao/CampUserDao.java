package com.chemi.campuser.dao;

import com.chemi.campuser.mapper.CampUserMapper;
import com.chemi.campuser.vo.*;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CampUserDao {
    private final CampUserMapper mapper;

    public List<CampImgVo> getCampImgList(String ownerNo) {
        return mapper.getCampImgList(ownerNo);
    }

    public List<CampSiteVo> campNameSelect(String name) {
        return mapper.campNameSelect(name);
    }

    public List<CampNoticeVo> getCampNoticeList(String ownerNo) {
        return mapper.getCampNoticeList(ownerNo);
    }

    public List<RefundVo> getrefundList(String ownerNo) {
        return mapper.getrefundList(ownerNo);
    }

//    public List<SeasonVo> getSeasonList(String ownerNo) {
//        return mapper.getSeasonList(ownerNo);
//    }

    public List<CampSiteVo> getCampSiteList() {
        return mapper.getCampSiteList();
    }

    public List<CampZoneVo> getCampZoneList(String ownerNo) {
        return mapper.getCampZoneList(ownerNo);
    }



}
