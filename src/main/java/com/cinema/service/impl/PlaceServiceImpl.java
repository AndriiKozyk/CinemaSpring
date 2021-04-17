package com.cinema.service.impl;

import com.cinema.dto.PlaceDto;
import com.cinema.model.Place;
import com.cinema.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements com.cinema.service.PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public PlaceDto getPlace(int id) {
        Place place = placeRepository.getPlace(id);
        return mapPlaceToPlaceDto(place);
    }

    @Override
    public PlaceDto createPlace(PlaceDto placeDto) {
        Place place = mapPlaceDtoToPlace(placeDto);
        place = placeRepository.createPlace(place);
        return mapPlaceToPlaceDto(place);
    }

    @Override
    public PlaceDto updatePlace(int id, PlaceDto placeDto) {
        Place place = mapPlaceDtoToPlace(placeDto);
        place = placeRepository.updatePlace(id, place);
        return mapPlaceToPlaceDto(place);
    }

    @Override
    public void deletePlace(int id) {
        placeRepository.deletePlace(id);
    }

    private PlaceDto mapPlaceToPlaceDto(Place place) {
        return PlaceDto.builder()
                .id(place.getId())
                .number(place.getNumber())
                .row(place.getRow())
                .build();
    }

    private Place mapPlaceDtoToPlace(PlaceDto placeDto) {
        return Place.builder()
                .row(placeDto.getRow())
                .number(placeDto.getNumber())
                .build();
    }

}
