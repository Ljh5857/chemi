package com.chemi.admin.mapper;

import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.member.vo.MemberVo;
import com.chemi.owner.vo.OwnerVo;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;

import java.util.List;

@Mapper
public interface AdminMapper {



    @Update("UPDATE OWNER SET JOIN_APPROVAL_YN = 'Y' WHERE NO = #{ownerVo.no}")
    boolean updateJoinApproval(@Param("ownerVo") OwnerVo ownerVo);

    @Select("SELECT * FROM OWNER WHERE JOIN_APPROVAL_YN = 'N'")
    List<OwnerVo> getOwnerList();

    @Select("SELECT SEQ_PRODUCT_NO.NEXTVAL AS no FROM DUAL")
    String selectNextProductNo();

    @Select("SELECT SEQ_PRD_IMG_NO.NEXTVAL AS imgNo FROM DUAL")
    String selectNextProductImgNo();

    @Insert("INSERT INTO PRODUCT (NO, CATEGORY_NO, NAME, PRICE, PROD_EXPLAIN, STOCK, CREATE_DATE) " +
            "VALUES (#{no}, #{categoryNo}, #{name}, #{price}, #{prodExplain}, #{stock}, SYSDATE)")
    void insertProduct(ProductVo productVo);

    @Insert("INSERT INTO PRD_IMG (NO, PRD_NO, PHOTO) VALUES (SEQ_PRD_IMG_NO.NEXTVAL, #{prdNo}, #{photo})")
    void insertPrdImg(PrdImgVo prdImgVo);

    @Update("UPDATE PRODUCT SET CATEGORY_NO = #{categoryNo}, NAME = #{name}, PRICE = #{price}, PROD_EXPLAIN = #{prodExplain}, STOCK = #{stock} WHERE NO = #{no}")
    void updateProduct(ProductVo productVo);

    @Select("SELECT NO, CATEGORY_NO, NAME, PRICE, PROD_EXPLAIN, STOCK FROM PRODUCT")
    List<ProductVo> getAllProducts();

    @Delete("DELETE FROM PRODUCT WHERE NO = #{productNo}")
    void deleteProduct();

    @Delete("DELETE FROM PRODUCT WHERE NO = #{imgNo}")
    void deleteProductImg();

    @Select("SELECT * FROM ADMIN WHERE ID = #{id} AND PWD = #{pwd}")
    String login(AdminVo vo);

    @Select("SELECT * FROM PRODUCT WHERE NO = #{no}")
    ProductVo getProductByNo(ProductVo vo);
}
