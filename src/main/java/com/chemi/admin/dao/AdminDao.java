package com.chemi.admin.dao;

import com.chemi.admin.mapper.AdminMapper;
import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.admin.vo.RefundVo;
import com.chemi.member.vo.MemberVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.security.AuthProvider;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminDao {

    private final AdminMapper mapper;



    public boolean updateJoinApproval(OwnerVo ownerVo) {
        return mapper.updateJoinApproval(ownerVo);
    }

    public List<OwnerVo> getOwnerList() {
        return mapper.getOwnerList();
    }

    public String selectNextProductNo() {
        return mapper.selectNextProductNo();
    }

    public String selectNextProductImgNo() {
        return mapper.selectNextProductImgNo();
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

    public void deleteProduct(String no) {
        System.out.println("AdminDao.deleteProduct");
        System.out.println("no = " + no);
        mapper.deleteProduct(no);
    }


    public void deleteProductImg(String no) {
        System.out.println("AdminDao.deleteProductImg");
        System.out.println("no = " + no);
        mapper.deleteProductImg(no);
    }

    public String login(AdminVo vo) {
        System.out.println("AdminDao.login");
        return mapper.login(vo);
    }

    public ProductVo getProductByNo(ProductVo vo) {
        return mapper.getProductByNo(vo);
    }

    public void setRefund(RefundVo vo) {

        mapper.setRefund(vo);

    }
}
