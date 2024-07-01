package com.chemi.owner.service;

import com.chemi.owner.dao.CampNoticeDao;
import com.chemi.owner.vo.CampNoticeVo;
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

    public int edit(CampNoticeVo vo) {
        return dao.edit(vo);
    }

    public CampNoticeVo noticeDetail(String no) {
        return dao.noticeDetail(no);
    }


}
