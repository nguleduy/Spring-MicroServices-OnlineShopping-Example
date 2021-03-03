package com.example.item.service.controller;

import com.example.item.service.dto.ItemDTO;
import com.example.item.service.service.ItemService;
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

@RequestMapping("/items")
@RestControllerAdvice
@RestController
public class ItemController {

  @Autowired
  private ItemService itemService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/")
  public List<ItemDTO> all() {
    return itemService.getItems();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public ItemDTO get(@PathVariable Long id) {
    return itemService.getItem(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public ItemDTO put(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
    itemDTO.setId(id);
    return itemService.saveItem(itemDTO);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    itemService.deleteItem(id);
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public ItemDTO add(@RequestBody ItemDTO itemDTO) {
    return itemService.saveItem(itemDTO);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Throwable ex) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
