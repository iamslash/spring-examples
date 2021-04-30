package com.iamslash.exflyway.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public List<String> getPeople() {
    return personRepository.findAll()
        .stream()
        .map(p -> p.getNAME())
        .collect(Collectors.toList());
  }
}
