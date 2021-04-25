package com.cinema.dto;

import com.cinema.model.enums.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class PlaceDto {

    private int id;
    private int number;
    private int row;
    private Type type;

}
