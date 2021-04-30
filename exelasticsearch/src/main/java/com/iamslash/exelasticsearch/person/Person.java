package com.iamslash.exelasticsearch.person;

import java.util.List;

public class Person {
  String name;
  String email;
  List<String> friends;
  int yearsOfJob;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getFriends() {
    return friends;
  }

  public void setFriends(List<String> friends) {
    this.friends = friends;
  }

  public int getYearsOfJob() {
    return yearsOfJob;
  }

  public void setYearsOfJob(int yearsOfJob) {
    this.yearsOfJob = yearsOfJob;
  }
}
