package com.example.onthi2.controller;

import com.example.onthi2.dto.ProductDto;
import com.example.onthi2.model.Category;
import com.example.onthi2.model.Product;
import com.example.onthi2.service.ICategoryService;
import com.example.onthi2.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RequestMapping("/product")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchDescriber", defaultValue = "") String describer, @PageableDefault(size = 3) Pageable pageable) {
        Page<Product> productList;
        ProductDto productDto = new ProductDto();
        productList = productService.searchName(name, describer, pageable);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("productDto", productDto);
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        return "/product/list";

    }

    @PostMapping("/add")
    public String addProduct(Model model, @Validated ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("mess", "thất bại");
            return "redirect:/product/show-list";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.addProduct(product);
            redirectAttributes.addFlashAttribute("mess", "thành công");
            return "redirect:/product/show-list";
        }
    }

    @PostMapping("/delete")
    public String delete( @RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "thành công");
        return "redirect:/product/show-list";


    }


}
