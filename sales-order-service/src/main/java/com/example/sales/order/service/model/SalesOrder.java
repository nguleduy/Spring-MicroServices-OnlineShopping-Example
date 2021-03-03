package com.example.sales.order.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private Date orderDate;

  @NotNull
  private Long custId;

  private String orderDesc;

  private Double totalPrice;

  @OneToMany(mappedBy = "salesOrder", cascade = {CascadeType.ALL})
  @JoinColumn(name = "id", referencedColumnName = "order_id")
  private List<OrderLineItem> orderLineItems;

  public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
    this.orderLineItems = orderLineItems;
    this.orderLineItems.forEach(orderLineItem -> orderLineItem.setSalesOrder(this));
  }
}
