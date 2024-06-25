package com.chemi.admin.mapper;

import com.chemi.admin.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM ADMIN WHERE ID = #{id} AND PWD = #{pwd}")
    AdminVo login(AdminVo adminVo);


}
