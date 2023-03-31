
package com.workshop.kartaca.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemFindResponse {

    private String name;
    private String description;
    private Date date;
    private Date lastDate;
    private Integer price;
}

