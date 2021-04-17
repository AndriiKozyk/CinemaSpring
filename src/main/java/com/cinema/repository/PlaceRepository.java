package com.cinema.repository;

import com.cinema.model.Place;

public interface PlaceRepository {

    Place getPlace(int id);

    Place createPlace(Place place);

    Place updatePlace(int id, Place place);

    void deletePlace(int id);

}
