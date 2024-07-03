package com.chemi.owner.mapper;

import com.chemi.owner.vo.ZoneVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ZoneMapper {

    @Insert("INSERT INTO ZONE\n" +
            "(NO, OWNER_NO, SEASON_NO, NAME, MAX_PEOPLE ,PRICE)\n" +
            "VALUES\n" +
            "(SEQ_ZONE_NO.NEXTVAL, #{ownerNo}, '1', #{name}, #{maxPeople}, #{price} )")
    int zoneInsert(ZoneVo vo);

    @Select("SELECT Z.CAMPSITE_NO , Z.SEASON_NO, Z.MAX_PEOPLE, Z.PRICE, Z.NAME\n" +
            "FROM ZONE Z\n" +
            "JOIN CAMPSITE C\n" +
            "ON Z.CAMPSITE_NO = C.NO\n" +
            "JOIN SEASON S\n" +
            "ON Z.SEASON_NO = S.NO\n" +
            "JOIN OWNER O\n" +
            "ON C.OWNER_NO = O.NO\n" +
            "WHERE O.NO = #{no}")
    List<ZoneVo> selectZone(String no);

    @Update(" UPDATE ZONE\n" +
            "        <set>\n" +
            "            <if test=\"name != null\">\n" +
            "                NAME = #{name},\n" +
            "            </if>\n" +
            "            <if test=\"price != null\">\n" +
            "                PRICE = #{price},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        WHERE CAMPSITE_NO = #{campsiteNo}")
    int updateZone(ZoneVo vo);
}
