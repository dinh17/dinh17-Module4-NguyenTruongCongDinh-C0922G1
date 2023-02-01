package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping
public class SandWichController {
    @GetMapping("")
    public String display(){
        return "/sandWich";
    }

    @GetMapping("/cv")
    public String getSpice(@RequestParam(value = "condiment" , defaultValue = "ăn gia vị đi")  String[] condiment, Model model){
        if (condiment.length >0){
             model.addAttribute("condiment", Arrays.toString(condiment));
        }
        return "/sandWich";
    }
}
