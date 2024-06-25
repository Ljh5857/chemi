package com.chemi.campsite.mapper;

import com.chemi.campsite.vo.CampsiteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampsiteMapper {

    @Select("SELECT NO, NAME, ADDRESS, TEL, DEL_YN, CAMPSITE_CATEGORY FROM CAMPSITE")
    List<CampsiteVo> findAll();
}