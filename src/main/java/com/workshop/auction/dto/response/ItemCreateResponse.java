
package com.workshop.auction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateResponse {

    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Date lastDate;
}

