package com.workshop.auction.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateRequest {

    private String name;
    private String description;
    private Integer price;
    private Integer hour;
}
