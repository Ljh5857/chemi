package com.chemi.owner.dao;

import com.chemi.owner.mapper.CampingMapper;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CampingDao {

    private final CampingMapper mapper;

    public CampingVo getCampByNo(String no) {
        return mapper.getCampByNo(no);
    }
}
