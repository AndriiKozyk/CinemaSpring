package com.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionHasPlace {

    private int id;
    private int placeId;
    private boolean available;

}
