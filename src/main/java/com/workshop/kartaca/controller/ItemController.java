package com.workshop.kartaca.controller;

import com.workshop.kartaca.dto.request.ItemCreateRequest;
import com.workshop.kartaca.dto.request.ItemDeleteRequest;
import com.workshop.kartaca.dto.request.ItemFindRequest;
import com.workshop.kartaca.dto.response.ItemCreateResponse;
import com.workshop.kartaca.dto.response.ItemDeleteResponse;
import com.workshop.kartaca.dto.response.ItemFindResponse;
import com.workshop.kartaca.entity.Item;
import com.workshop.kartaca.repository.ItemRepository;
import com.workshop.kartaca.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;
    private final ItemRepository repository;

    @PostMapping("/create")
    public ResponseEntity<ItemCreateResponse> createItem(
            @RequestBody ItemCreateRequest request
    ) {
        return ResponseEntity.ok(service.createItem(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> item = repository.findAll();
        if (item.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(item);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFindResponse> getItemById(
            @RequestBody ItemFindRequest request
    ) {
        return ResponseEntity.ok(service.getItemById(request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteItem(
            @RequestBody ItemDeleteRequest request
    ) {
        return ResponseEntity.ok(service.deleteItem(request));
    }

/*
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer id, @RequestBody Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item updatedItem = itemRepository.save(item);
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
*/

}
