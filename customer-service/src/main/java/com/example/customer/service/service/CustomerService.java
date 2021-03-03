package com.example.customer.service.service;

import com.example.customer.service.dto.CustomerDTO;
import com.example.customer.service.model.Customer;
import com.example.customer.service.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class CustomerService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CustomerRepository customerRepository;

  public List<CustomerDTO> getCustomers() {
    return customerRepository.findAll().stream().map(c -> modelMapper.map(c, CustomerDTO.class))
            .collect(Collectors.toList());
  }

  public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
    Customer customer = customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    return modelMapper.map(customer, CustomerDTO.class);
  }

  public CustomerDTO getCustomer(Long customerId) {
    return modelMapper.map(customerRepository.findById(customerId), CustomerDTO.class);
  }

  public void deleteCustomer(Long customerId) {
    customerRepository.deleteById(customerId);
  }

}
