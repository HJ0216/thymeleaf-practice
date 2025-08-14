package com.practice.thymeleaf_tutorial.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserResponse {

  String name;
  String email;
  String gender;
  String role;

}
