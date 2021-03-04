package com.example.customer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Serializable {

  private static final Long serialVersionUID = 1L;

  private Long id;
  private String email;
  private String firstName;
  private String lastName;
}
