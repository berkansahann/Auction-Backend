package com.workshop.auction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidFindResponse {

    private Integer id;
    private String userFirstName;
    private String userLastName;
    private Integer itemId;
    private Integer price;
}
