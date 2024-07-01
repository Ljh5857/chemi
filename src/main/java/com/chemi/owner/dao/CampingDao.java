package com.chemi.owner.dao;

import com.chemi.owner.mapper.CampingMapper;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CampingDao {

    private final CampingMapper mapper;

    public CampingVo getCampByNo(String no) {
        return mapper.getCampByNo(no);
    }



    public int insertCamp(CampingVo vo) {
        return mapper.insertCamp(vo);
    }

    public int editCamp(String tel, String ownerNo) {
        return mapper.editCamp(tel , ownerNo);
    }

    public int updateFacility(String name) {
        return mapper.updateFacility(name);
    }
}
