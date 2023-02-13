package com.example.exercise.controller;

import com.example.exercise.dto.UserDto;
import com.example.exercise.model.User;
import com.example.exercise.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class FormController {

        @Autowired
       private IUserService userService;

        @GetMapping("")
        public String showResult(){
            return "user/result";
        }

        @GetMapping("/create")
        public String showAdd(Model model){
            model.addAttribute("userDto", new UserDto());
            return "create";
        }

        @PostMapping("/create")
        public String add(@Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
            if(bindingResult.hasErrors()){
                return "/user/create";
            }
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.add(user);
            redirectAttributes.addFlashAttribute("mess","Đăng ký thành công");
            return "redirect:/user";
        }

}
