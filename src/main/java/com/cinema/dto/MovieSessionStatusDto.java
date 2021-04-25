package com.cinema.dto;

import com.cinema.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class MovieSessionStatusDto {

    private Long id;
    private Status status;

}
