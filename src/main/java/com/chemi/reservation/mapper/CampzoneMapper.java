package com.chemi.reservation.mapper;

import com.chemi.reservation.vo.CampzoneVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CampzoneMapper {

    @Select("SELECT * FROM zone")
    List<CampzoneVo> getAllCampzones();

    @Select("SELECT * FROM zone WHERE no = #{no}")
    CampzoneVo getCampzoneById(int no);

    @Insert("INSERT INTO zone (no, campsite_no, season_no, max_people, price, zone_category) VALUES (#{no}, #{campsiteNo}, #{seasonNo}, #{maxPeople}, #{price}, #{zoneCategory})")
    void saveCampzone(CampzoneVo campzone);
}