package com.practice.thymeleaf_tutorial.controller;

import com.practice.thymeleaf_tutorial.dto.response.UserResponse;
import com.practice.thymeleaf_tutorial.form.UserRegisterForm;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @GetMapping("/variable")
  public String expressVariable(Model model) {
    UserResponse response = new UserResponse("name", "name@email.com", "female", "user");
    model.addAttribute("user", response);
    return "user";
  }

  @GetMapping("selection")
  public String expressSelection(Model model) {
    UserResponse response = new UserResponse("name", "name@email.com", "female", "user");
    model.addAttribute("user", response);
    return "user";
  }

  @GetMapping("message")
  public String expressMessage(Model model) {
    UserResponse response = new UserResponse("name", "name@email.com", "female", "user");
    model.addAttribute("user", response);
    return "user";
  }

  @GetMapping("link")
  public String expressLink(Model model) {
    model.addAttribute("id", 1);
    return "user";
  }

  @GetMapping("/iteration")
  public String iterate(Model model) {
    UserResponse user1 = new UserResponse("name1", "name1@email.com", "female", "user");
    UserResponse user2 = new UserResponse("name2", "name2@email.com", "female", "user");
    UserResponse user3 = new UserResponse("name3", "name3@email.com", "female", "user");
    model.addAttribute("users", List.of(user1, user2, user3));
    return "user";
  }

  @GetMapping("/if")
  public String filterUsingIf(Model model) {
    UserResponse user1 = new UserResponse("name1", "name1@email.com", "female", "admin");
    UserResponse user2 = new UserResponse("name2", "name2@email.com", "female", "user");
    UserResponse user3 = new UserResponse("name3", "name3@email.com", "female", "user");
    model.addAttribute("users", List.of(user1, user2, user3));
    return "user";
  }

  @GetMapping("/switch")
  public String filterUsingSwitch(Model model) {
    UserResponse user1 = new UserResponse("name1", "name1@email.com", "female", "admin");
    UserResponse user2 = new UserResponse("name2", "name2@email.com", "male", "user");
    UserResponse user3 = new UserResponse("name3", "name3@email.com", "unknown", "user");
    model.addAttribute("users", List.of(user1, user2, user3));
    return "user";
  }

  @GetMapping("/register")
  public String showRegisterPage(Model model) {
    model.addAttribute("form", new UserRegisterForm());
    model.addAttribute("professions", List.of("dev", "tester", "architect"));
    return "register-form";
  }

  @PostMapping
  public String submit(Model model, @ModelAttribute UserRegisterForm form) {
    model.addAttribute("form", form);
    return "user";
  }

}
