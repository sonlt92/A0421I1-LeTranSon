package com.letranson.furama.controller;

import com.letranson.furama.bean.*;
import com.letranson.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping(value = "/contract")
public class ContractController{
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ServiceService serviceService;

    @Autowired AttachServiceService attachServiceService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers(){
        return customerService.findAll();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> employees(){
        return employeeService.findAllNotPage();
    }

    @ModelAttribute("services")
    public Iterable<Service> services(){
        return serviceService.findAllNotPage();
    }

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices(){
        return attachServiceService.findAll();
    }

    @ModelAttribute
    public Model getUserName(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser,Model model){
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return model;
    }

    @GetMapping(value = "/show")
    public ModelAndView show(@PageableDefault(value = 5) Pageable pageable){
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/listUseService");
        if (contracts.getContent().size() == 0){
            modelAndView.addObject("msg","Chưa có khách hàng nào sử dụng dịch vụ.");
        }
        modelAndView.addObject("contracts",contracts);
        return modelAndView;
    }

    @GetMapping(value = "/tableContract")
    public ModelAndView getPageContract(@PageableDefault(value = 5) Pageable pageable){
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/tableContract");
        if (contracts.getContent().size() == 0){
            modelAndView.addObject("msg","Chưa có khách hàng nào sử dụng dịch vụ.");
        }
        modelAndView.addObject("contracts",contracts);
        return modelAndView;
    }

    @GetMapping(value = "/createContract")
    public ModelAndView showPageCreateContract(){
        ModelAndView modelAndView = new ModelAndView("contract/createContract");
        modelAndView.addObject("contract",new Contract());
        return modelAndView;
    }

    @PostMapping(value = "/createContract")
    public String saveContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "contract/createContract";
        }else {
            redirectAttributes.addFlashAttribute("msg", "Create contract of customer: " + contract.getCustomer().getCustomerName() + " success.");
            contractService.save(contract);
            return "redirect:/contract/show";
        }
    }

    @GetMapping(value = "/createContractDetail")
    public String showPageCreateContractDetail(Model model){
        model.addAttribute("contract",contractService.findAllNotPage());
        model.addAttribute("contractDetail",new ContractDetail());
        return "contract/createContractDetail";
    }

    @PostMapping(value = "/createContractDetail")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Create contract detail of customer: "+contractDetail.getContract().getCustomer().getCustomerName()+" success.");
        contractDetailService.save(contractDetail);
        return "redirect:/contract/show";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showPageEdit(@PathVariable("id") Integer id){
        Contract contract = contractService.findById(id);
        return new ModelAndView("contract/editContract","contract",contract);
    }

    @PostMapping(value = "/editContract")
    public String editContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "/contract/editContract";
        }else {
            redirectAttributes.addFlashAttribute("msg", "Update contract of customer: " + contract.getCustomer().getCustomerName() + " success.");
            contractService.save(contract);
            return "redirect:/contract/show";
        }
    }

    @GetMapping(value = "delete/{id}")
    public String removeContract(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        Contract contract = contractService.findById(id);
        if (contract.getContractDetails().size() > 0){
            contractDetailService.remove(contract);
        }
        contractService.delete(contract);
        redirectAttributes.addFlashAttribute("msg", "Deleted contract of customer: " + contract.getCustomer().getCustomerName() + " success.");
        return "redirect:/contract/show";
    }
}
