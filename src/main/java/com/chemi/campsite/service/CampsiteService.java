package com.chemi.campsite.service;

import com.chemi.campsite.dao.CampsiteDao;
import com.chemi.campsite.vo.CampsiteVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampsiteService {

    private final CampsiteDao campsiteDao;

    public CampsiteService(CampsiteDao campsiteDao) {
        this.campsiteDao = campsiteDao;
    }

    public List<CampsiteVo> findAll() {
        return campsiteDao.findAll();
    }
}