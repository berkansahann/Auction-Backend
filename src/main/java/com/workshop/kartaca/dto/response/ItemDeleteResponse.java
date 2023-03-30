package com.workshop.kartaca.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ItemDeleteResponse {

    private String message = "Item deleted successfully";
}
