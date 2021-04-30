package com.iamslash.exjunit.api.v1;

import com.iamslash.exjunit.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/api/v1/user")
  public UserDto createUser(@RequestBody UserDto userDto) {
    return userDto;
  }
}
