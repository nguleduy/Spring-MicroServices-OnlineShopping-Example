package com.example.sales.order.service.controller;

import com.example.sales.order.service.dto.SalesOrderDTO;
import com.example.sales.order.service.service.SalesOrderService;
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

@RequestMapping("/orders")
@RestControllerAdvice
@RestController
public class SalesOrderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrderController.class);

  @Autowired
  private SalesOrderService salesOrderService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/")
  public List<SalesOrderDTO> getSalesOrders() {
    return salesOrderService.getSalesOrders();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public SalesOrderDTO getSalesOrder(@PathVariable Long id) {
    return salesOrderService.getSalesOrder(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public SalesOrderDTO put(@PathVariable Long id, @RequestBody SalesOrderDTO salesOrderDTO) {
    salesOrderDTO.setId(id);
    return salesOrderService.save(salesOrderDTO);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    salesOrderService.delete(id);
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public SalesOrderDTO add(@RequestBody SalesOrderDTO salesOrderDTO) {
    return salesOrderService.save(salesOrderDTO);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Throwable ex) {
    LOGGER.error("There was an error: ", ex);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
