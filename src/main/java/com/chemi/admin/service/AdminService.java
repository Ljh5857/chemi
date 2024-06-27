package com.chemi.admin.service;

import com.chemi.admin.dao.AdminDao;
import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.CombinedResponse;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    public boolean login(AdminVo adminVo) {
        AdminVo result = dao.login(adminVo);
        return result != null;
    }

    public boolean approveOwner(OwnerVo ownerVo) {
        return dao.updateJoinApproval(ownerVo);
    }

    public List<OwnerVo> getOwnerList() {
        return dao.getOwnerList();
    }


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

    @Transactional
    public void updateProduct(ProductVo productVo) {
        dao.updateProduct(productVo);
    }


    @Transactional
    public List<ProductVo> getAllProducts() {

        List<ProductVo> products = dao.getAllProducts();

        logger.info("getAllProducts() 호출됨. 조회된 상품 수: {}", products.size());


        return dao.getAllProducts();
    }
}
