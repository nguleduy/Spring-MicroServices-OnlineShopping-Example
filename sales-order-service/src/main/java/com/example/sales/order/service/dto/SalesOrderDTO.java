package com.example.sales.order.service.dto;

import com.example.sales.order.service.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderDTO {

  private Long id;
  private Timestamp orderDate;
  private Long custId;
  private String orderDesc;
  private Double totalPrice;
  private Set<OrderLineItem> orderLineItems;
}
