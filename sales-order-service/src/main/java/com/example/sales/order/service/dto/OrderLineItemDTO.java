package com.example.sales.order.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemDTO {

  private Long id;
  private Long orderId;
  private String itemName;
  private Long itemQuantity;
}
