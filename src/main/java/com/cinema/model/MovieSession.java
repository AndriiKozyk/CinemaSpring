package com.cinema.model;

import com.cinema.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class MovieSession {

    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;
    private Long movieId;
    private Status status;
    private List<SessionHasPlace> places;

}
