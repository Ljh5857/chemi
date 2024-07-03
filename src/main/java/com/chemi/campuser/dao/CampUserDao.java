package com.chemi.campuser.dao;

import com.chemi.campuser.mapper.CampUserMapper;
import com.chemi.owner.vo.CampImgVo;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CampUserDao {
    private final CampUserMapper mapper;


    public List<CampingVo> CampList() {

        return mapper.CampList();
    }
    public CampingVo getCampingDetail(String campNo) {
        return mapper.getCampingDetail(campNo);
    }

    public List<CampImgVo> getCampImgList(String campNo) {
        return mapper.getCampImgList(campNo);
    }

    public List<CampingVo> campNameSelect() {
        return mapper.campNameSelect();
    }
}
