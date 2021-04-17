package com.cinema.service;

import com.cinema.dto.PlaceDto;

public interface PlaceService {

    PlaceDto getPlace(int id);

    PlaceDto createPlace(PlaceDto placeDto);

    PlaceDto updatePlace(int id, PlaceDto placeDto);

    void deletePlace(int id);

}
