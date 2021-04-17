package com.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {

    private Long id;
    private Long userId;
    private Long sessionId;
    private Long sessionPlaceId;

}
