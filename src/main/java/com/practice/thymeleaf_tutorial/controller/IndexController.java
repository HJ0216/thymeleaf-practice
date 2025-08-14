package com.practice.thymeleaf_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @GetMapping
  public String index(Model model) {
    model.addAttribute("message", "hello-world");
    return "index";
  }

  @GetMapping("/main")
  public String expressFragment(Model model) {
    return "main";
  }

}
