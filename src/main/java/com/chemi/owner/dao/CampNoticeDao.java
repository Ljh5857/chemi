package com.chemi.owner.dao;

import com.chemi.owner.mapper.CampNoticeMapper;
import com.chemi.owner.vo.CampNoticeVo;
import com.chemi.owner.vo.CampingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class CampNoticeDao {

    private final CampNoticeMapper mapper;

    public List<CampNoticeVo> getCampNotice(String no) {
        return mapper.getCampNotice(no);
    }

    public int insertNotice(CampNoticeVo vo) {
        return mapper.insertNotice(vo);
    }

    public CampingVo noticeByNo(String no) {
        return mapper.noticeByNo(no);
    }
}
