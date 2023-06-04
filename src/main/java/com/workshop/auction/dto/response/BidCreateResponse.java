package com.workshop.auction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidCreateResponse {
    private int id;
    private int userId;
    private int itemId;
    private int price;
}
