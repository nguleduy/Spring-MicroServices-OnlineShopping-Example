package com.example.sales.order.service.config;

import com.example.sales.order.service.dto.OrderLineItemDTO;
import com.example.sales.order.service.listener.CustomerMessageListener;
import com.example.sales.order.service.model.Customer;
import com.example.sales.order.service.model.OrderLineItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(OrderLineItem.class, OrderLineItemDTO.class);
    modelMapper.createTypeMap(OrderLineItemDTO.class, OrderLineItem.class);

    TypeMap<CustomerMessageListener.CustomerListenerDTO, Customer> typeMap = modelMapper.createTypeMap(CustomerMessageListener.CustomerListenerDTO.class, Customer.class);
    typeMap.addMappings(new PropertyMap<CustomerMessageListener.CustomerListenerDTO, Customer>() {
      @Override
      protected void configure() {
        map().setCustEmail(source.getEmail());
        map().setCustId(source.getId());
        map().setCustFirstName(source.getFirstName());
        map().setCustLastName(source.getLastName());
      }
    });

    return modelMapper;
  }
}
