package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    private Long id;
    private Long userId;
    private Long sessionId;
    private Long sessionPlaceId;

}
