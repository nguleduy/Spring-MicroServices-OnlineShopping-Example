package com.example.sales.order.service.dto;

import com.example.sales.order.service.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderDTO {

  private Long id;
  private Date orderDate;
  private Long custId;
  private String orderDesc;
  private Double totalPrice;
  private List<OrderLineItem> orderLineItems;
}
