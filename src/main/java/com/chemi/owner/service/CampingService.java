package com.chemi.owner.service;

import com.chemi.owner.dao.CampingDao;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CampingService {

    private final CampingDao dao;

    public CampingVo getCampByNo(String no) {
        return dao.getCampByNo(no);
    }


    public int insertCamp(CampingVo vo) {
        return dao.insertCamp(vo);
    }

    public int editCamp(String tel, String ownerNo) {
        return dao.editCamp(tel , ownerNo);
    }

    public int updateFacility(String no, String name) {
        return dao.updateFacility(no, name);
    }
}
