package com.chemi.admin.mapper;

import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.owner.vo.OwnerVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM ADMIN WHERE ID = #{id} AND PWD = #{pwd}")
    AdminVo login(AdminVo adminVo);

    @Update("UPDATE OWNER SET JOIN_APPROVAL_YN = 'Y' WHERE NO = #{ownerVo.No}")
    boolean updateJoinApproval(@Param("ownerVo") OwnerVo ownerVo);

    @Select("SELECT * FROM OWNER WHERE JOIN_APPROVAL_YN = 'N'")
    List<OwnerVo> getOwnerList();

    @Select("SELECT SEQ_PRODUCT_NO.NEXTVAL AS no FROM DUAL")
    String selectNextProductNo();

    @Insert("INSERT INTO PRODUCT (NO, CATEGORY_NO, NAME, PRICE, PROD_EXPLAIN, STOCK, CREATE_DATE) " +
            "VALUES (#{no}, #{categoryNo}, #{name}, #{price}, #{prodExplain}, #{stock}, SYSDATE)")
    void insertProduct(ProductVo productVo);

    @Insert("INSERT INTO PRD_IMG (NO, PRD_NO, PHOTO) VALUES (SEQ_PRD_IMG_NO.NEXTVAL, #{prdNo}, #{photo})")
    void insertPrdImg(PrdImgVo prdImgVo);

    @Update("UPDATE PRODUCT SET CATEGORY_NO = #{categoryNo}, NAME = #{name}, PRICE = #{price}, PROD_EXPLAIN = #{prodExplain}, STOCK = #{stock} WHERE NO = #{no}")
    void updateProduct(ProductVo productVo);

    @Select("SELECT NO, CATEGORY_NO, NAME, PRICE, PROD_EXPLAIN, STOCK FROM PRODUCT")
    List<ProductVo> getAllProducts();

}
