package com.chemi.campsite.dao;

import com.chemi.campsite.mapper.CampsiteMapper;
import com.chemi.campsite.vo.CampsiteVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampsiteDao {

    private final CampsiteMapper campsiteMapper;

    public CampsiteDao(CampsiteMapper campsiteMapper) {
        this.campsiteMapper = campsiteMapper;
    }

    public List<CampsiteVo> findAll() {
        return campsiteMapper.findAll();
    }
}