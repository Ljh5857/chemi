package com.chemi.reservation.controller;

import com.chemi.reservation.service.CampzoneService;
import com.chemi.reservation.vo.CampzoneVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campzone")
public class CampzoneController {

    private final CampzoneService campzoneService;

    public CampzoneController(CampzoneService campzoneService) {
        this.campzoneService = campzoneService;
    }

    @GetMapping
    public List<CampzoneVo> getAllCampzones() {
        return campzoneService.getAllCampzones();
    }

    @GetMapping("/get")
    public CampzoneVo getCampzoneById(@RequestParam int no) {
        return campzoneService.getCampzoneById(no);
    }

    @PostMapping("/save")
    public void saveCampzone(@RequestBody CampzoneVo campzone) {
        campzoneService.saveCampzone(campzone);
    }
}
