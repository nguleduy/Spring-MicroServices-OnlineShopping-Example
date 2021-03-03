package com.example.item.service.service;

import com.example.item.service.dto.ItemDTO;
import com.example.item.service.model.Item;
import com.example.item.service.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ItemService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ItemRepository itemRepository;

  public List<ItemDTO> getItems() {
    return itemRepository.findAll().stream().map(item -> modelMapper.map(item, ItemDTO.class))
            .collect(Collectors.toList());
  }

  public ItemDTO saveItem(ItemDTO itemDTO) {
    Item item = itemRepository.save(modelMapper.map(itemDTO, Item.class));
    return modelMapper.map(item, ItemDTO.class);
  }

  public ItemDTO getItem(Long itemId) {
    return modelMapper.map(itemRepository.findById(itemId), ItemDTO.class);
  }

  public ItemDTO getItem(String name) {
    return modelMapper.map(itemRepository.findByName(name), ItemDTO.class);
  }

  public void deleteItem(Long itemId) {
    itemRepository.deleteById(itemId);
  }
}
