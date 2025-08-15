package com.practice.thymeleaf_tutorial.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping
  public String home(Model model) {

    LocalDateTime now  = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss");

    model.addAttribute("now", now.format(formatter));
    model.addAttribute("welcome", "Hello Thymeleaf");
    model.addAttribute("version", "v1.0");

    return "index";
  }

}
