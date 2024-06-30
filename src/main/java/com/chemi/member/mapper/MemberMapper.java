package com.chemi.member.mapper;

import com.chemi.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {

  @Insert("INSERT INTO MEMBER ( NO,ID,PWD,NICK,ADDRESS,ZIP_CODE,PHONE,NAME,EMAIL)VALUES(SEQ_MEMBER_NO.NEXTVAL,#{id},#{pwd},#{nick},#{address},#{zipCode},#{phone},#{name},#{email})")
  int join(MemberVo vo);


  @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND PWD = #{pwd} AND DEL_YN = 'N'")
  String login(MemberVo vo);

  @Select("SELECT * FROM MEMBER WHERE PHONE = #{phone} AND EMAIL = #{email}")
  MemberVo selectId(MemberVo vo);

  @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND EMAIL = #{email} AND PHONE = #{phone}")
  MemberVo selectPwd(MemberVo vo);

  @Update("UPDATE MEMBER SET PWD = #{pwd} WHERE ID = #{id} AND PHONE = #{phone} AND EMAIL = #{email}")
  int changePwd(MemberVo vo);

  @Update("UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = #{no}")
  int delUser(MemberVo vo);

  @Select("SELECT * FROM MEMBER WHERE NO = #{no}")
  String myPage(MemberVo vo);

}