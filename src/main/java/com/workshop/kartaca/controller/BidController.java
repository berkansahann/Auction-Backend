package com.workshop.kartaca.controller;

import com.workshop.kartaca.dto.request.BidCreateRequest;
import com.workshop.kartaca.dto.response.BidCreateResponse;
import com.workshop.kartaca.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
