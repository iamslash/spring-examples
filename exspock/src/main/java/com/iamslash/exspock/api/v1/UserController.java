package com.iamslash.exspock.api.v1;

import com.iamslash.exspock.dto.UserDto;
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
