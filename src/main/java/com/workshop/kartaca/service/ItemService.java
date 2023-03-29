package com.workshop.kartaca.service;

import com.workshop.kartaca.dto.request.ItemCreateRequest;
import com.workshop.kartaca.dto.response.ItemCreateResponse;
import com.workshop.kartaca.entity.Item;
import com.workshop.kartaca.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public ItemCreateResponse createItem(ItemCreateRequest request){
        Date date = new Date();
        var item = Item.builder()
                .name(request.getName())
                .description(request.getDescription())
                .date(date)
                .lastdate(new Date(date.getTime() + 1000 * 60 * 60 * 24))
                .price(request.getPrice())
                .build();
        repository.save(item);
        return ItemCreateResponse.builder()
                .name(item.getName())
                .description(item.getDescription())
                .lastdate(item.getLastdate())
                .price(item.getPrice())
                .build();
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }
/*
      public Optional<Item> getItemById(Integer id) {
        return itemRepository.findById(id);
    }

    public Optional<Item> updateItem(Integer id, Item newItem) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item oldItem = existingItem.get();
            oldItem.setName(newItem.getName());
            oldItem.setDescription(newItem.getDescription());
            oldItem.setDate(newItem.getDate());
            oldItem.setPrice(newItem.getPrice());
            return Optional.of(itemRepository.save(oldItem));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteItem(Integer id) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            itemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }*/
}
