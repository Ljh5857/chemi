package com.chemi.admin.controller;

import com.chemi.admin.service.AdminService;
import com.chemi.admin.vo.AdminVo;
import com.chemi.admin.vo.CombinedResponse;
import com.chemi.admin.vo.PrdImgVo;
import com.chemi.admin.vo.ProductVo;
import com.chemi.member.vo.MemberVo;
import com.chemi.owner.vo.OwnerVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String login(AdminVo vo, HttpSession ss) {
        String loginResult = service.login(vo);
        System.out.println("AdminController.login");
        if ("success".equals(loginResult)) {
            ss.setAttribute("admin", vo);
        }
        System.out.println("vo = " + vo);
        System.out.println("loginResult = " + loginResult);
        return "redirect:/admin/adminMain";
    }

    @PostMapping("approveOwner")
    public ModelAndView approveOwner(@ModelAttribute OwnerVo ownerVo, RedirectAttributes redirectAttributes) {
        System.out.println("AdminController.approveOwner");
        System.out.println("ownerVo.getNo() = " + ownerVo.getNo());
        
        boolean isApproved = service.approveOwner(ownerVo);

        if (isApproved) {
            // 성공할 경우 adminMain으로 리다이렉트
            return new ModelAndView("redirect:/admin/adminMain");
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

    @GetMapping("productInsert")
    public String showProductInsertForm() {
        return "admin/productInsert";
    }

    @PostMapping("productInsert")
    public String insertProduct(
            @RequestParam("categoryNo") String categoryNo,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("prodExplain") String prodExplain,
            @RequestParam("stock") String stock,
            @RequestParam("photo") String photo,
            Model model) {

        System.out.println("AdminController.insertProduct");

        ProductVo productVo = new ProductVo();
        productVo.setCategoryNo(categoryNo);
        productVo.setName(name);
        productVo.setPrice(price);
        productVo.setProdExplain(prodExplain);
        productVo.setStock(stock);

        PrdImgVo prdImgVo = new PrdImgVo();
        prdImgVo.setPhoto(photo);
        prdImgVo.setDelYn("N");  // 기본값 설정

        System.out.println("AdminController.insertProduct2");

        CombinedResponse response = service.insertProduct(productVo, prdImgVo);

        System.out.println("AdminController.insertProduct3");

        model.addAttribute("productVo", response.getProductVo());
        model.addAttribute("prdImgVo", response.getPrdImgVo());
        model.addAttribute("message", "Product inserted successfully");
        return "redirect:/admin/productInsert";
    }

    @GetMapping("productList")
    public String getProductList(Model model) {
        List<ProductVo> product = service.getAllProducts();
        model.addAttribute("product", product);
        return "admin/productList";
    }

    @GetMapping("productUpdate")
    public String showProductUpdate(ProductVo vo) {
        System.out.println("AdminController.showProductUpdate");
        service.getProductByNo(vo);
        System.out.println("vo = " + vo);
        return "admin/productUpdate";
    }

    @PostMapping("productUpdate")
    public String updateProduct(ProductVo productVo) {
        service.updateProduct(productVo);
        return "redirect:/admin/productList";
    }

    @DeleteMapping("productDelete")
    public String deleteProduct(@RequestParam("no") String no, RedirectAttributes redirectAttributes) {
        boolean isDeleted = service.deleteProduct(no);
        if (isDeleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Product successfully deleted.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete product.");
        }
        return "redirect:/admin/productList";
    }





}
