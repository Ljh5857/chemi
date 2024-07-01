package com.chemi.owner.mapper;

import com.chemi.owner.vo.CampNoticeVo;
import com.chemi.owner.vo.CampingVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface CampNoticeMapper {

    @Select("SELECT CN.NO, CN.TITLE, CN.CONTENT, CN.UPLOAD_DATE,CN.HIT\n" +
            "FROM CAMPSITE_NOTICE CN\n" +
            "JOIN CAMPSITE C\n" +
            "ON CN.CAMPSITE_NO = C.NO\n" +
            "JOIN OWNER O\n" +
            "ON C.OWNER_NO = O.NO\n" +
            "WHERE O.NO = #{no} AND CN.DEL_YN = 'N'\n" +
            ";")
    List<CampNoticeVo> getCampNotice(String no);

    @Insert("INSERT INTO CAMPSITE_NOTICE\n" +
            "(NO, CAMPSITE_NO, TITLE, CONTENT)\n" +
            "VALUES\n" +
            "(SEQ_CAMPSITE_NOTICE.NEXTVAL, #{campsiteNo} , #{title} , #{content})")
    int insertNotice(CampNoticeVo vo);

    @Select("SELECT * FROM CAMPSITE_NOTICE WHERE NO = #{no} AND DEL_YN = 'N'")
    CampingVo noticeByNo(String no);

    @Update("UPDATE CAMPSITE_NOTICE SET TITLE = #{title}, CONTENT = #{content} WHERE NO = #{no}")
    int edit(CampNoticeVo vo);

    @Select("SELECT * FROM CAMPSITE_NOTICE WHERE NO = #{no}")
    CampNoticeVo noticeDetail(String no);
}
