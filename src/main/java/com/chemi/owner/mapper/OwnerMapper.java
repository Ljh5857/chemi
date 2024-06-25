package com.chemi.owner.mapper;

import com.chemi.owner.vo.OwnerVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OwnerMapper {

    @Select("SELECT * FROM OWNER WHERE NO = #{vo.no}")
    OwnerVo login(OwnerVo vo);

    @Insert("INSERT INTO OWNER " +
            "(NO,ID,PWD,NICK,NAME,PHONE,EMAIL,ADDRESS,ZIP_CODE,BUSINESS_NUM)" +
            "VALUES " +
            "(SEQ_OWNER.NEXTVAL, #{vo.id}, #{vo.pwd}, #{vo.nick}, #{vo.name}, #{vo.phone}, #{vo.email}, #{vo.address}, #{vo.zipCode}, #{vo.businessNum} )")
    int join(OwnerVo vo);

    @Update("UPDATE OWNER SET PWD = #{vo.pwd} WHERE NO = #{no}")
    int pwdEdit(OwnerVo vo);
}
