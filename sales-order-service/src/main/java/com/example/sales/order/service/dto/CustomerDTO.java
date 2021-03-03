package com.example.sales.order.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private Long custId;
  private String custEmail;
  private String custFirstName;
  private String custLastName;
}
