package com.iamslash.exjpa.hello;

import com.iamslash.exjpa.domain.posts.Posts;
import com.iamslash.exjpa.domain.posts.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  PostsService postsService;

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @GetMapping("/world")
  public String world() {

    Posts posts = Posts.builder()
        .author("John")
        .title("World")
        .content("Hello World")
        .build();

    postsService.save(posts);

    return "world";
  }
}
