package com.chemi.product.controller;


import com.chemi.product.service.ProdService;
import com.chemi.product.vo.ProdVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prod")
@RequiredArgsConstructor
public class ProdController {

    private final ProdService service;

    @GetMapping("list")
    public List<ProdVo> getProdList(){
        System.out.println(service.getProdList());
        return service.getProdList();
    }
    @PostMapping("detail")
    public List<ProdVo> getProdCategoryList(@RequestBody ProdVo vo){

        List<ProdVo> voList = service.getProdCategoryList(vo.getCategoryNo());
        System.out.println(vo.getCategoryNo());

        return voList;
    }

}
