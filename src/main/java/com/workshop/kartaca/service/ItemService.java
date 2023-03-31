package com.workshop.kartaca.service;

import com.workshop.kartaca.dto.request.ItemCreateRequest;
import com.workshop.kartaca.dto.request.ItemDeleteRequest;
import com.workshop.kartaca.dto.request.ItemFindRequest;
import com.workshop.kartaca.dto.request.ItemUpdateRequest;
import com.workshop.kartaca.dto.response.ItemCreateResponse;
import com.workshop.kartaca.dto.response.ItemDeleteResponse;
import com.workshop.kartaca.dto.response.ItemFindResponse;
import com.workshop.kartaca.dto.response.ItemUpdateResponse;
import com.workshop.kartaca.entity.Item;
import com.workshop.kartaca.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public ItemCreateResponse createItem(ItemCreateRequest request) {
        Date date = new Date();
        int x = request.getHour();
        var item = Item.builder()
                .name(request.getName())
                .description(request.getDescription())
                .date(date)
                .lastDate(new Date(date.getTime() + 1000L * 60 * 60 * x))
                .price(request.getPrice())
                .firstPrice(request.getPrice())
                .build();
        repository.save(item);
        return ItemCreateResponse.builder()
                .name(item.getName())
                .description(item.getDescription())
                .lastDate(item.getLastDate())
                .price(item.getPrice())
                .build();
    }

    public ItemFindResponse getItemById(ItemFindRequest request) {
        var item = repository.findById(request.getId())
                .orElseThrow();
        return ItemFindResponse.builder()
                .name(item.getName())
                .description(item.getDescription())
                .date(item.getDate())
                .lastDate(item.getLastDate())
                .price(item.getPrice())
                .build();
    }

    public ItemDeleteResponse deleteItem(ItemDeleteRequest request) {
        repository.deleteById(request.getId());
        return ItemDeleteResponse.builder()
                .build();
    }

    public ItemUpdateResponse updateItem(ItemUpdateRequest request) {
        var item = repository.findById(request.getId())
                .orElseThrow();
        item.setPrice(request.getPrice());
        repository.save(item);
        return ItemUpdateResponse.builder()
                .id(item.getId())
                .price(item.getPrice())
                .build();
    }
}
