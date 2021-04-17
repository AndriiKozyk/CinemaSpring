package com.cinema.dto;

import com.cinema.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class MovieSessionGeneralDto {

    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;
    private Long movieId;
    private Status status;

}
