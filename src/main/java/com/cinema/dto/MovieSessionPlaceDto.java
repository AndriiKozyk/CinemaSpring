package com.cinema.dto;

import com.cinema.model.SessionHasPlace;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class MovieSessionPlaceDto {

    private Long id;
    private List<SessionHasPlace> places;

}
