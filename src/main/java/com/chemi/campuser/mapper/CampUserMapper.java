package com.chemi.campuser.mapper;

import com.chemi.campuser.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CampUserMapper {

    //캠핑장+캠핑장이미지 셀렉트 //TODO 캠핑상세조회(이미지)
    @Select("SELECT * FROM CAMPSITE c " +
            "JOIN CAMP_IMG ci ON c.NO = ci.CAMPSITE_NO " +
            "WHERE c.OWNER_NO = #{ownerNo} " +
            "AND c.DEL_YN = 'N' " +
            "AND ci.DEL_YN = 'N' " +
            "AND c.BLIND_CAMP = 'N'")
    List<CampImgVo> getCampImgList(@Param("ownerNo") String campNo);

    //캠핑장 이름으로 검색
    @Select("SELECT * FROM CAMPSITE WHERE NAME = #{name}")
    List<CampSiteVo> campNameSelect(@Param("name") String name);

    //캠핑장 + 캠핑장 공지사항
    @Select("SELECT cn.* " +
            "FROM CAMPSITE c " +
            "JOIN CAMPSITE_NOTICE cn ON c.OWNER_NO = cn.OWNER_NO " +
            "WHERE c.OWNER_NO = #{ownerNo} " +
            "AND c.DEL_YN = 'N' " +
            "AND c.BLIND_CAMP = 'N' " +
            "AND cn.DEL_YN = 'N'")
    List<CampNoticeVo> getCampNoticeList(@Param("ownerNo") String ownerNo);

    //캠핑장 + 환불규정
    @Select("SELECT CR.* " +
            "FROM CAMPSITE C " +
            "JOIN REFUND CR ON C.NO = CR.NO " +
            "WHERE C.OWNER_NO = #{ownerNo} " +
            "AND C.DEL_YN = 'N' " +
            "AND C.BLIND_CAMP = 'N'")
    List<RefundVo> getrefundList(@Param("ownerNo") String ownerNo);

//    //캠핑장 + 캠핑존 + 시즌
//    @Select("")
//    List<SeasonVo> getSeasonList(String ownerNo);

    //캠핑장 전체 목록조회
    @Select("SELECT * FROM CAMPSITE")
    List<CampSiteVo> getCampSiteList();

    //캠핑존 + 캠핑존 이미지
    @Select("SELECT Z.*, ZI.FILE_PATH, ZI.CREATE_DATE " +
            "FROM ZONE Z " +
            "JOIN ZONE_IMG ZI ON Z.NO = ZI.ZONE_NO " +
            "WHERE Z.OWNER_NO = #{ownerNo} " +
            "AND ZI.DEL_YN = 'N'")
    List<CampZoneVo> getCampZoneList(@Param("ownerNo") String ownerNo);


}
