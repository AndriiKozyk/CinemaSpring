package com.cinema.dto;

import com.cinema.model.SessionHasPlace;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieSessionPlaceDto {

    private Long id;
    private List<SessionHasPlace> places;

}
