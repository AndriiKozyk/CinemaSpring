package com.cinema.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class TicketDto {

    private Long id;
    private Long userId;
    private Long sessionId;
    private Long sessionPlaceId;

}
