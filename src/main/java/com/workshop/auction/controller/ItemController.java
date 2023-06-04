package com.workshop.auction.controller;

import com.workshop.auction.dto.request.ItemCreateRequest;
import com.workshop.auction.dto.request.ItemDeleteRequest;
import com.workshop.auction.dto.request.ItemUpdateRequest;
import com.workshop.auction.dto.response.ItemCreateResponse;
import com.workshop.auction.dto.response.ItemDeleteResponse;
import com.workshop.auction.dto.response.ItemFindResponse;
import com.workshop.auction.dto.response.ItemUpdateResponse;
import com.workshop.auction.entity.Item;
import com.workshop.auction.repository.ItemRepository;
import com.workshop.auction.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
            @PathVariable int id)
    {
        return ResponseEntity.ok(service.getItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteItem(
            @RequestBody ItemDeleteRequest request
    ) {
        return ResponseEntity.ok(service.deleteItem(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemUpdateResponse> updateItem(
            @RequestBody ItemUpdateRequest request
    ) {
        return ResponseEntity.ok(service.updateItem(request));
    }
}
