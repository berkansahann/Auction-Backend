package com.workshop.kartaca.dto.response;

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
    private Integer userId;
    private Integer itemId;
    private Integer price;
}
