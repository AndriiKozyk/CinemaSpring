package com.cinema.repository.impl;

import com.cinema.model.Place;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceRepositoryImpl implements com.cinema.repository.PlaceRepository {

    private final List<Place> list = new ArrayList<>();

    @Override
    public Place getPlace(int id) {
        return list.stream()
                .filter(place -> place.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Place createPlace(Place place) {
        list.add(place);
        return place;
    }

    @Override
    public Place updatePlace(int id, Place place) {
        boolean isDeleted = list.removeIf(p -> p.getId() == id);
        if (isDeleted) {
            list.add(place);
        } else {
            throw new RuntimeException("Place does not exist with id " + id);
        }
        return place;
    }

    @Override
    public void deletePlace(int id) {
        list.removeIf(place -> place.getId() == id);
    }

}
