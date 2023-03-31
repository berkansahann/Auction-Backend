package com.workshop.kartaca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidCreateRequest {

    private int userId;
    private int itemId;
    private int price;
}
