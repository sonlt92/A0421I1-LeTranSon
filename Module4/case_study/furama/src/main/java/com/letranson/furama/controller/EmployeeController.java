package com.letranson.furama.controller;

import com.letranson.furama.bean.*;
import com.letranson.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @ModelAttribute
    public Model getUserName(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser,Model model){
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return model;
    }

    @ModelAttribute("education")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("position")
    public Iterable<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("division")
    public Iterable<Division> divisions() {
        return divisionService.findAll();
    }

    @GetMapping(value = "/show")
    public ModelAndView showPageEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/showEmployee");
        if (employees.getContent().size() == 0) {
            modelAndView.addObject("msg", "Chưa có nhân viên nào.");
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping(value = "/tableEmployee")
    public ModelAndView getTableEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/tableEmployee");
        if (employees.getContent().size() == 0) {
            modelAndView.addObject("msg", "Chưa có nhân viên nào.");
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping(value = "/search/{searchValue}")
    public ModelAndView showSearch(@PageableDefault(value = 5) Pageable pageable, @PathVariable("searchValue") String name) {
        Page<Employee> employees = employeeService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("employee/resultSearch");
        if (employees.getContent().size() == 0) {
            modelAndView.addObject("msg", "Not found.");
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showPageCreateEmployee(Model model) {
        model.addAttribute("employeeUser", new EmployeeUser());
        return "employee/createEmployee";
    }

    @PostMapping(value = "/create")
    public String saveEmployee(@Validated @ModelAttribute EmployeeUser employeeUser, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/createEmployee";
        } else {
            if (userService.checkUserName(employeeUser.getUserName())) {
                model.addAttribute("msgUserName", "Tên đăng nhập đã tồn tại.");
                return "employee/createEmployee";
            } else {
                redirectAttributes.addFlashAttribute("msg", "Create employee: " + employeeUser.getName() + " success.");

                new User();
                User user;
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String pass = bCryptPasswordEncoder.encode(employeeUser.getPassWord());


                Set<Role> roles = new HashSet<>();
                if (employeeUser.getPosition().getName().equals("Giám đốc") || employeeUser.getPosition().getName().equals("Quản lý")) {
                    roles.add(roleService.findById(1));
                } else {
                    roles.add(roleService.findById(2));
                }
                user = new User(employeeUser.getUserName(), pass, roles);


                String idEmployee = "NV-" + ((int) (Math.random() * 10000));
                Employee employee = new Employee(idEmployee, employeeUser.getName(), employeeUser.getBirthday(), employeeUser.getIdCard(),
                        employeeUser.getSalary(), employeeUser.getPhone(), employeeUser.getEmail(), employeeUser.getAddress(),
                        employeeUser.getPosition(), employeeUser.getEducationDegree(), employeeUser.getDivision(), user);

                userService.save(user);
                employeeService.save(employee);

                return "redirect:/employee/show";
            }
        }
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView showPageUpdateEmployee(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("employee/updateEmployee", "employee", employee);
    }

    @PostMapping(value = "/update")
    public String updateEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/updateEmployee";
        }else {
            redirectAttributes.addFlashAttribute("msg", "Update employee: " + employee.getName() + " success.");
            employeeService.save(employee);
            return "redirect:/employee/show";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        return "redirect:/employee/show";
    }
}