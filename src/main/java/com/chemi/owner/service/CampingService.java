package com.chemi.owner.service;

import com.chemi.owner.dao.CampingDao;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingDao dao;

    public CampingVo getCampByNo(String no) {
        return dao.getCampByNo(no);
    }

    public List<CampingVo> getCampNotice(String no) {
        return dao.getCampNotice(no);
    }

    public int insertCamp(CampingVo vo) {
        return dao.insertCamp(vo);
    }
}
