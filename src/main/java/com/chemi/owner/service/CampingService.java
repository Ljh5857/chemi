package com.chemi.owner.service;

import com.chemi.owner.dao.CampingDao;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingDao dao;

    public CampingVo getCampByNo(String no) {
        return dao.getCampByNo(no);
    }
}
