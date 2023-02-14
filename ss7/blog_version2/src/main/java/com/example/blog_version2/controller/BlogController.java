package com.example.blog_version2.controller;

import com.example.blog_version2.model.Blog;
import com.example.blog_version2.service.IBlogService;
import com.example.blog_version2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String blogsList(@PageableDefault Pageable pageable, @RequestParam(value="search",defaultValue = "")String search, Model model){
        model.addAttribute("blogList",iBlogService.searchByTitle(search,pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", search);
        return "home";
    }
    @GetMapping("/view/{id}")
    public String View (@PathVariable int id,Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "view";
    }

    @GetMapping("/delete/{id}")
    public  String  delete(@PathVariable int id,Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "delete";
    }
   @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess","Remove successful!");
        return  "redirect:/";
   }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }
    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add new successful!");
        return "redirect:/";
    }

}
