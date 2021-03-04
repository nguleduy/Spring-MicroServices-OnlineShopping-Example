package com.example.sales.order.service.listener;

import com.example.sales.order.service.service.CustomerService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerMessageListener {

  @Autowired
  private CustomerService customerService;

  @KafkaListener(topics = "customer-created")
  public void handle(String json) {
    Gson gson = new Gson();
    CustomerListenerDTO customer = gson.fromJson(json, CustomerListenerDTO.class);
    System.out.println("Received: " + customer);
    customerService.save(customer);
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CustomerListenerDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
  }

}
