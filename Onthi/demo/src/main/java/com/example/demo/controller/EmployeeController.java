package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;

    @GetMapping(value = "/list")

    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, @PageableDefault(size = 2) Pageable pageable) {
        Page<Employee> employeeList;
        employeeList = employeeService.searchName(name, email, pageable);
        List<Position> positionList = positionService.getAllPosition();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);

        return "/employee/list";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer( BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String mess = "";

            for (String key : errors.keySet()) {
                mess += "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
            }
            return mess;
        } else {
            Employee employee = new Employee();
            boolean check = employeeService.add(employee);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
        }
        return "redirect:/employee/list";

    }
}
