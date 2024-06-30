package com.chemi.member.mapper;


import com.chemi.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckMemberMapper {

    @Select("SELECT ID FORM MEMBER WHERE ID = #{id}")
    String checkId(MemberVo vo);


}
