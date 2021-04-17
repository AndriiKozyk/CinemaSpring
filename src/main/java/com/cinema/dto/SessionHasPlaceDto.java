package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionHasPlaceDto {

    private int id;
    private int placeId;
    private boolean available;

}
