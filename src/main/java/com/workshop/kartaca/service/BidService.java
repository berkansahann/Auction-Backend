package com.workshop.kartaca.service;

import com.workshop.kartaca.dto.request.BidCreateRequest;
import com.workshop.kartaca.dto.response.BidCreateResponse;
import com.workshop.kartaca.dto.response.BidFindResponse;
import com.workshop.kartaca.entity.Bid;
import com.workshop.kartaca.entity.Item;
import com.workshop.kartaca.entity.User;
import com.workshop.kartaca.repository.BidRepository;
import com.workshop.kartaca.repository.ItemRepository;
import com.workshop.kartaca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BidService {

    private final BidRepository bidRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public BidCreateResponse createBid(BidCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        Item item = itemRepository.findById(request.getItemId()).orElseThrow();
        if (request.getPrice() <= item.getPrice()) {
            throw new RuntimeException("Bid price must be higher than current price");
        }
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

    /*public BidFindResponse getBidById(@PathVariable int id) {
        var bid = bidRepository.findById(id)
                .orElseThrow();
        var user = userRepository.findById(bid.getUser().getId())
                .orElseThrow();
        return BidFindResponse.builder()
                .id(bid.getId())
                .userFirstName(user.getFirstName())
                .userLastName(user.getLastName())
                .itemId(bid.getItem().getId())
                .price(bid.getPrice())
                .build();
    }*/

/*    public BidFindResponse getBidsByItem_Id(@PathVariable int id){
        var bid = bidRepository.getBidsByItem_Id(id);
        var user = userRepository.findById(bid.get(0).getUser().getId())
                .orElseThrow();
        return BidFindResponse.builder()
                .id(bid.get(0).getId())
                .userFirstName(user.getFirstName())
                .userLastName(user.getLastName())
                .itemId(bid.get(0).getItem().getId())
                .price(bid.get(0).getPrice())
                .build();
    }*/

    public List<BidFindResponse> getBidsByItem_Id(@PathVariable int id) {
        var bids = bidRepository.getBidsByItem_Id(id);
        List<BidFindResponse> bidFindResponses = new ArrayList<>();
        for (Bid bid : bids) {
            var user = userRepository.findById(bid.getUser().getId())
                    .orElseThrow();
            var bidFindResponse = BidFindResponse.builder()
                    .id(bid.getId())
                    .userFirstName(user.getFirstName())
                    .userLastName(user.getLastName())
                    .itemId(bid.getItem().getId())
                    .price(bid.getPrice())
                    .build();
            bidFindResponses.add(bidFindResponse);
        }
        return bidFindResponses;
    }
}
