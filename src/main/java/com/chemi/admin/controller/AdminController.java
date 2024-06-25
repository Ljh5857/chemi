package com.chemi.admin.controller;

import com.chemi.admin.service.AdminService;
import com.chemi.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping("adminMain")
    public String test(){

        return "admin/adminMain";
    }


    @GetMapping("login")
    public String login(){
        return "admin/login";
    }

    @PostMapping("login")
    public ModelAndView adminLogin(@ModelAttribute AdminVo adminVo) {
        ModelAndView modelAndView = new ModelAndView();

        boolean isValid = service.login(adminVo);

        if (isValid) {
            modelAndView.setViewName("admin/adminMain");
        } else {
            modelAndView.setViewName("admin/login");
            modelAndView.addObject("error", "Invalid ID or Password");
        }

        return modelAndView;
    }

    @PostMapping("approveOwner")
    public String approveOwner(){



        return "";
    }




}
