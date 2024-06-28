package com.chemi.owner.service;

import com.chemi.owner.dao.ZoneDao;
import com.chemi.owner.vo.ZoneVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneDao dao;

    public int zoneInsert(ZoneVo vo) {
        return dao.zoneInsert(vo);
    }

    public List<ZoneVo> selectZone(String no) {
        return dao.selectZone(no);
    }

    public int updateZone(ZoneVo vo) {
        return dao.updateZone(vo);
    }
}
