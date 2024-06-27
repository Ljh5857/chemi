package com.chemi.product.service;

import com.chemi.product.dao.ProdDao;
import com.chemi.product.vo.ProdVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdService {

    private final ProdDao dao;

    public List<ProdVo> getProdList() {
        return dao.getProdList();
    }

    public List<ProdVo> getProdCategoryList(String no) {
        return dao.getProdCategoryList(no);
    }


}
