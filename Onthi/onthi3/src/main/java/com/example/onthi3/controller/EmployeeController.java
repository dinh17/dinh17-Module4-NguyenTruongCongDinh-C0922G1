package com.example.onthi3.controller;



import com.example.onthi3.model.Employee;
import com.example.onthi3.model.EmployeeDto;
import com.example.onthi3.model.Position;
import com.example.onthi3.service.IEmployeeService;
import com.example.onthi3.service.IPositionService;
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


import java.util.List;



@RequestMapping("/employee")
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService positionService;

    @GetMapping(value = "/show-list")

    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, @PageableDefault(size = 2) Pageable pageable) {
        Page<Employee> employeeList;
        EmployeeDto employeeDto = new EmployeeDto();
        employeeList = employeeService.searchName(name, email, pageable);
        List<Position> positionList = positionService.getAllPosition();
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);
        return "/employee/list";
    }

    @PostMapping(value = "/add")
    public String addEmployee(@Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("mess","thất bại ");
            return "redirect:/employee/show-list";
        }else{
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.add(employee);
            redirectAttributes.addFlashAttribute("mess","thành công");
            return "redirect:/employee/show-list";
        }
    }
    @PostMapping(value = "/edit")
    public String editEmployee(@Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("mess","thất bại ");
            return "redirect:/employee/show-list";
        }else{
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.edit(employee);
            redirectAttributes.addFlashAttribute("mess","thành công");
            return "redirect:/employee/show-list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/employee/show-list";
    }
}
