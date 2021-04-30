package com.iamslash.exflyway.person;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
  @Id @GeneratedValue
  @Column(name = "ID")
  private int ID;

  @Column(name = "NAME")
  private String NAME;

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return ID == person.ID &&
        Objects.equals(NAME, person.NAME);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, NAME);
  }
}
