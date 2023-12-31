package com.app.model.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "customers")
public class Customer {

  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;
  private String lastName;
  private String firstName;
  private String email;
  private String company;
  private String phone;
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String postalCode;
  private String country;
  @Transient
  private String balance;

  public Customer() {
  }
}
