package com.example.sales.order.service.service;

import com.example.sales.order.service.dto.CustomerDTO;
import com.example.sales.order.service.listener.CustomerMessageListener;
import com.example.sales.order.service.model.Customer;
import com.example.sales.order.service.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CustomerRepository customerRepository;

  public CustomerDTO save(CustomerMessageListener.CustomerListenerDTO customer) {
    Customer result = customerRepository.save(modelMapper.map(customer, Customer.class));
    return modelMapper.map(result, CustomerDTO.class);
  }

}
