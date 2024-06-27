package com.chemi.owner.service;

import com.chemi.owner.dao.CampNoticeDao;
import com.chemi.owner.vo.CampNoticeVo;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampNoticeService {

    private final CampNoticeDao dao;

    public List<CampNoticeVo> getCampNotice(String no) {
        return dao.getCampNotice(no);
    }

    public int insertNotice(CampNoticeVo vo) {
        return dao.insertNotice(vo);
    }

    public CampingVo noticeByNo(String no) {
        return dao.noticeByNo(no);
    }
}
