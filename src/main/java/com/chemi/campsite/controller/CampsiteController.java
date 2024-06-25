package com.chemi.campsite.controller;

import com.chemi.campsite.vo.CampsiteVo;
import com.chemi.campsite.service.CampsiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campsites")
public class CampsiteController {

    private final CampsiteService campsiteService;

    public CampsiteController(CampsiteService campsiteService) {
        this.campsiteService = campsiteService;
    }

    @GetMapping
    public List<CampsiteVo> getAllCampsites() {
        return campsiteService.findAll();
    }
}