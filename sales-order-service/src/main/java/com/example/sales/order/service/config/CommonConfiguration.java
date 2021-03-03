package com.example.sales.order.service.config;

import com.example.sales.order.service.dto.OrderLineItemDTO;
import com.example.sales.order.service.model.OrderLineItem;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(OrderLineItem.class, OrderLineItemDTO.class);
    modelMapper.createTypeMap(OrderLineItemDTO.class, OrderLineItem.class);
    return modelMapper;
  }
}
