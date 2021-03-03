package com.example.sales.order.service.service;

import com.example.sales.order.service.dto.SalesOrderDTO;
import com.example.sales.order.service.model.SalesOrder;
import com.example.sales.order.service.repository.SalesOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class SalesOrderService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private SalesOrderRepository salesOrderRepository;

  public List<SalesOrderDTO> getSalesOrders() {
    return salesOrderRepository.findAll().stream().map(c -> modelMapper.map(c, SalesOrderDTO.class))
            .collect(Collectors.toList());
  }

  public SalesOrderDTO save(SalesOrderDTO salesOrderDTO) {
    SalesOrder salesOrder = salesOrderRepository.save(modelMapper.map(salesOrderDTO, SalesOrder.class));
    return modelMapper.map(salesOrder, SalesOrderDTO.class);
  }

  public SalesOrderDTO getSalesOrder(Long orderId) {
    return modelMapper.map(salesOrderRepository.findById(orderId), SalesOrderDTO.class);
  }

  public void delete(Long orderId) {
    salesOrderRepository.deleteById(orderId);
  }
}
