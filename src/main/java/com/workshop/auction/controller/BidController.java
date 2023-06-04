package com.workshop.auction.controller;

import com.workshop.auction.dto.request.BidCreateRequest;
import com.workshop.auction.dto.response.BidCreateResponse;
import com.workshop.auction.dto.response.BidFindResponse;
import com.workshop.auction.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bid")
@RequiredArgsConstructor
public class BidController {

    private final BidService service;

    @PostMapping("/create")
    public ResponseEntity<BidCreateResponse> createBid(
            @RequestBody BidCreateRequest request
    ) {
        return ResponseEntity.ok(service.createBid(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BidFindResponse>> getBidsByItem_Id(
            @PathVariable int id)
    {
        return ResponseEntity.ok(service.getBidsByItem_Id(id));
    }
}
