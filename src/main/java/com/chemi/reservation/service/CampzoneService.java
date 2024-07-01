package com.chemi.reservation.service;

import com.chemi.reservation.dao.CampzoneDao;
import com.chemi.reservation.vo.CampzoneVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampzoneService {

    private final CampzoneDao campzoneDao;

    public CampzoneService(CampzoneDao campzoneDao) {
        this.campzoneDao = campzoneDao;
    }

    public List<CampzoneVo> getAllCampzones() {
        return campzoneDao.getAllCampzones();
    }

    public CampzoneVo getCampzoneById(int no) {
        return campzoneDao.getCampzoneById(no);
    }

    public void saveCampzone(CampzoneVo campzone) {
        campzoneDao.saveCampzone(campzone);
    }
}
