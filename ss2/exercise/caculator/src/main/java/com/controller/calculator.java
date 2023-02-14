package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class calculator {
    @GetMapping("")
    public String displayCalculator() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String Calculator(Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operator") String operator) {
        String result = null;
        switch (operator) {
            case "Addition(+)":
                result = String.valueOf(num1 + num2);
                break;
            case "Subtraction(-)":
                result = String.valueOf(num1 - num2);
                break;
            case "Multiplication(*)":
                result = String.valueOf(num1 * num2);
                break;
            case "Division(/)":
                if (num2 == 0) {
                    result = " loi~";

                } else {
                    result = String.valueOf(num1 / num2);

                }
                break;
            default:
                result = null;

        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);


        return "calculator";
    }
}
