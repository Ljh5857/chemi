package com.chemi.admin.mapper;

import com.chemi.admin.vo.AdminVo;
import com.chemi.owner.vo.OwnerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM ADMIN WHERE ID = #{id} AND PWD = #{pwd}")
    AdminVo login(AdminVo adminVo);

    @Update("UPDATE OWNER SET JOIN_APPROVAL_YN = 'Y' WHERE NO = #{ownerVo.No}")
    boolean updateJoinApproval(@Param("ownerVo") OwnerVo ownerVo);

    @Select("SELECT * FROM OWNER WHERE JOIN_APPROVAL_YN = 'N'")
    List<OwnerVo> getOwnerList();
}
