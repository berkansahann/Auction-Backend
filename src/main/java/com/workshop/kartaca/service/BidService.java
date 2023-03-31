package com.workshop.kartaca.service;

import com.workshop.kartaca.dto.request.BidCreateRequest;
import com.workshop.kartaca.dto.response.BidCreateResponse;
import com.workshop.kartaca.entity.Bid;
import com.workshop.kartaca.entity.Item;
import com.workshop.kartaca.entity.User;
import com.workshop.kartaca.repository.BidRepository;
import com.workshop.kartaca.repository.ItemRepository;
import com.workshop.kartaca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BidService {

    private final BidRepository bidRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public BidCreateResponse createBid(BidCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        Item item = itemRepository.findById(request.getItemId()).orElseThrow();

        var bid = Bid.builder()
                .user(user)
                .item(item)
                .price(request.getPrice())
                .build();
        bidRepository.save(bid);

        item.setPrice(bid.getPrice());
        itemRepository.save(item);

        return BidCreateResponse.builder()
                .id(bid.getId())
                .userId(user.getId())
                .itemId(item.getId())
                .price(bid.getPrice())
                .build();
    }
}