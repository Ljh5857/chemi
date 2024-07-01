package com.chemi.owner.mapper;

import com.chemi.owner.vo.CampingVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CampingMapper {

    @Select("SELECT * FROM CAMPSITE WHERE OWNER_NO = #{no}")
    CampingVo getCampByNo(String no);



    @Insert("INSERT INTO CAMPSITE\n" +
            "(NO,OWNER_NO,NAME, ADDRESS,TEL,INTRODUCTION,BASIC_INFO,ZONE_LAYOUT_IMG,AREA,CAMPSITE_CATEGORY)\n" +
            "VALUES\n" +
            "(SEQ_CAMPSITE_NO.NEXTVAL,#{ownerNo},#{name},#{address},#{tel},#{introduction},#{basicInfo},#{zoneImg},#{area},#{campsiteCategory} )")
    int insertCamp(CampingVo vo);

    @Update("UPDATE CAMPSITE SET TEL = #{tel} WHERE OWNER_NO = #{ownerNo}")
    int editCamp(String tel, String ownerNo);

    @Update("UPDATE CAMPSITE SET  ")
    int updateFacility(String name);
}
