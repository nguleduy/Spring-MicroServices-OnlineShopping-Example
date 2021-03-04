package com.example.customer.service.controller;

import com.example.customer.service.dto.CustomerDTO;
import com.example.customer.service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RequestMapping("/customers")
@RestControllerAdvice
@RestController
public class CustomerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  private CustomerService customerService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/")
  public List<CustomerDTO> getCustomers() {
    return customerService.getCustomers();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public CustomerDTO getCustomer(@PathVariable Long id) {
    return customerService.getCustomer(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public CustomerDTO put(@PathVariable Long id, CustomerDTO customerDTO) {
    customerDTO.setId(id);
    return customerService.saveCustomer(customerDTO);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerDTO add(@RequestBody CustomerDTO customerDTO) {
    return customerService.saveCustomer(customerDTO);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Throwable ex) {
    LOGGER.error("There was an error: ", ex);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
