package com.example.sales.order.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_line_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private Long orderId;

  @NotNull
  private String itemName;

  @NotNull
  private Long itemQuantity;
}
