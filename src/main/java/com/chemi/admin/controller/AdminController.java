package com.chemi.admin.controller;

import com.chemi.admin.service.AdminService;
import com.chemi.admin.vo.AdminVo;
import com.chemi.owner.vo.OwnerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public ModelAndView approveOwner(@ModelAttribute OwnerVo ownerVo, RedirectAttributes redirectAttributes) {
        System.out.println("AdminController.approveOwner");
        System.out.println("ownerVo.getNo() = " + ownerVo.getNo());
        
        boolean isApproved = service.approveOwner(ownerVo);

        if (isApproved) {
            // 성공할 경우 adminMain으로 리다이렉트
            return new ModelAndView("redirect:/adminMain");
        } else {
            // 실패할 경우 다시 approveOwner.jsp로 리다이렉트하고 에러 메시지 전달
            redirectAttributes.addFlashAttribute("error", "Approval failed. Please try again.");
            return new ModelAndView("redirect:/approveOwner.jsp");
        }
    }

    @GetMapping("approveOwner")
    public String getOwnerList(Model model) {

        List<OwnerVo> ownerList = service.getOwnerList();
        model.addAttribute("ownerList", ownerList);
        return "admin/approveOwner";
    }



}
