package com.chemi.owner.mapper;

import com.chemi.owner.vo.CampingVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CampingMapper {

    @Select("SELECT * FROM CAMPSITE WHERE OWNER_NO = #{no}")
    CampingVo getCampByNo(String no);
}
