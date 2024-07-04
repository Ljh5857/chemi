package com.chemi.admin.service;

import com.chemi.admin.dao.AdminDao;
import com.chemi.admin.vo.*;
import com.chemi.member.vo.MemberVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    // 관리자 로그인
    public String login(AdminVo vo) {
        System.out.println("AdminService.login");
        return dao.login(vo);
    }


    // Owner 수락
    public boolean approveOwner(OwnerVo ownerVo) {
        return dao.updateJoinApproval(ownerVo);
    }

    // Owner 수락을 위한 목록 뽑아오기
    public List<OwnerVo> getOwnerList() {
        return dao.getOwnerList();
    }


    //상품 등록
    @Transactional
    public CombinedResponse insertProduct(ProductVo productVo, PrdImgVo prdImgVo) {

        String no = dao.selectNextProductNo();
        System.out.println("no = " + no);

        productVo.setNo(no);
        prdImgVo.setPrdNo(no);

        System.out.println("Product no in productVo: " + productVo.getNo());

        dao.insertProduct(productVo);
        dao.insertPrdImg(prdImgVo);

        CombinedResponse response = new CombinedResponse();
        response.setProductVo(productVo);
        response.setPrdImgVo(prdImgVo);

        return response;
    }

    // 상품 목록 수정
    @Transactional
    public void updateProduct(ProductVo productVo) {
        dao.updateProduct(productVo);
    }


    // 상품 수정,삭제하기위한 목록 뽑아오기
    @Transactional
    public List<ProductVo> getAllProducts() {

        List<ProductVo> products = dao.getAllProducts();
        logger.info("getAllProducts() 호출됨. 조회된 상품 수: {}", products.size());

        return dao.getAllProducts();
    }


    public boolean deleteProduct(String no) {
        System.out.println("AdminService.deleteProduct");
        System.out.println("no = " + no);
        try {
            dao.deleteProductImg(no);
            dao.deleteProduct(no);

            return true;
        } catch (Exception e) {
            logger.error("Error deleting product: ", e);
            return false;
        }
    }


    public ProductVo getProductByNo(ProductVo vo) {

        return dao.getProductByNo(vo);

    }

    public void setRefund(RefundVo vo) {

        dao.setRefund(vo);

    }
}
