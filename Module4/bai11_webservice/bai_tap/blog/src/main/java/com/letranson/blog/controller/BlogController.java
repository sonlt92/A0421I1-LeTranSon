package com.letranson.blog.controller;

import com.letranson.blog.bean.Blog;
import com.letranson.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;


@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/")
    public ModelAndView showHomePage(@PageableDefault(value = 5) Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs",blogs);
        if (blogs.getContent().size()==0) {
            modelAndView.addObject("msg", "Chưa có bài viết nào.");
        }
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showPageCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute Blog blog, @RequestParam("img") MultipartFile img, RedirectAttributes redirectAttributes){
        if (img.isEmpty()){
            blog.setLinkImg("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = img.getInputStream();
            Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            blog.setLinkImg(img.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        blog.setDate(String.valueOf(today));

        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping(value = "edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping(value = "show/{id}")
    public ModelAndView showDetailPage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        return "redirect:/";
    }
}
