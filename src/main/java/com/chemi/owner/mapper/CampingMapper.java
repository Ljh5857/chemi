package com.chemi.owner.mapper;

import com.chemi.owner.vo.CampingVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampingMapper {

    @Select("SELECT * FROM CAMPSITE WHERE OWNER_NO = #{no}")
    CampingVo getCampByNo(String no);

    @Select("SELECT CN.NO, CN.TITLE, CN.CONTENT, CN.UPLOAD_DATE,CN.HIT\n" +
            "FROM CAMPSITE_NOTICE CN\n" +
            "JOIN CAMPSITE C\n" +
            "ON CN.CAMPSITE_NO = C.NO\n" +
            "JOIN OWNER O\n" +
            "ON C.OWNER_NO = O.NO\n" +
            "WHERE O.NO = #{no} AND CN.DEL_YN = 'N'\n" +
            ";")
    List<CampingVo> getCampNotice(String no);

    @Insert("INSERT INTO CAMPSITE\n" +
            "(NO,OWNER_NO,NAME, ADDRESS,TEL,INTRODUCTION,BASIC_INFO,ZONE_LAYOUT_IMG,AREA,CAMPSITE_CATEGORY)\n" +
            "VALUES\n" +
            "(SEQ_CAMPSITE_NO.NEXTVAL,#{ownerNo},#{name},#{address},#{tel},#{introduction},#{basicInfo},#{zoneLayoutImg},#{area},#{campsiteCategory}")
    int insertCamp(CampingVo vo);
}
