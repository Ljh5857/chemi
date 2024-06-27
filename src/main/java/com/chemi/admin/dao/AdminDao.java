package com.chemi.admin.dao;

import com.chemi.admin.mapper.AdminMapper;
import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.security.AuthProvider;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminDao {

    private final AdminMapper mapper;

    public AdminVo login(AdminVo adminVo) {

        return mapper.login(adminVo);
    }

    public boolean updateJoinApproval(OwnerVo ownerVo) {
        return mapper.updateJoinApproval(ownerVo);
    }

    public List<OwnerVo> getOwnerList() {
        return mapper.getOwnerList();
    }

    public String selectNextProductNo() {
        return mapper.selectNextProductNo();
    }


    public void insertProduct(ProductVo productVo) {
        mapper.insertProduct(productVo);
    }

    public void insertPrdImg(PrdImgVo prdImgVo) {
        mapper.insertPrdImg(prdImgVo);
    }

    public void updateProduct(ProductVo productVo) {
        mapper.updateProduct(productVo);
    }


    public List<ProductVo> getAllProducts() {
        return mapper.getAllProducts();
    }

}
