package com.cinema.controller.model;

import com.cinema.dto.TicketDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class TicketModel extends RepresentationModel<TicketModel> {

    @JsonUnwrapped
    private TicketDto ticketDto;

}
