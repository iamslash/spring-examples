package com.iamslash.exjpa.domain.posts;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PostsService {

  PostsRepository postsRepository;

  public PostsService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  public void save(Posts posts) {
    postsRepository.save(posts);
  }
}
