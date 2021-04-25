package com.cinema.dto;

import com.cinema.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class MovieSessionGeneralDto {

    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;
    private Long movieId;
    private Status status;

}
