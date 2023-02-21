package com.example.case_study.controller;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.customer.CustomerDto;
import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.ICustomerTypeService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, @RequestParam(value = "searchCustomerTypeId", defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerList;
        if (customerTypeId == -1) {
            customerList = customerService.searchName(name, email, pageable);
        } else {
            customerList = customerService.searchName(name, email, customerTypeId, pageable);
        }
        CustomerDto customerDto = new CustomerDto();
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg= "";

            for(String key: errors.keySet()){
                errorMsg+= "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
            }
            return errorMsg;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            boolean check = customerService.addNewCustomer(customer);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
        }
        return "redirect:/customer/show-list";

    }

    @PostMapping(value = "/edit")
    public String editCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String mess= "";

            for(String key: errors.keySet()){
                mess+= "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/customer/show-list";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            boolean check = customerService.editCustomer(customer);
            String mess;
            if (check) {
                mess = "Chỉnh sửa thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);

        }
        return "redirect:/customer/show-list";
    }

    @PostMapping(value = "/delete")
    public String deleteCustomer(CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(customerDto.getId());
        customer.setDeleted(true);
        boolean check = customerService.editCustomer(customer);
        String mess;
        if (check) {
            mess = "Xóa thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer/show-list";
    }

}
