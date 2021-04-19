package com.cinema.dto;

import com.cinema.model.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieSessionStatusDto {

    private Long id;
    private Status status;

}
