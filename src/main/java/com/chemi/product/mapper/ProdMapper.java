package com.chemi.product.mapper;

import com.chemi.product.vo.ProdVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProdMapper {
    @Select("SELECT * FROM PRODUCT")
    List<ProdVo> getProdList();

    @Select("SELECT * FROM PRODUCT WHERE CATEGORY_NO = #{no}")
    List<ProdVo> getProdCategoryList(String no);


}
