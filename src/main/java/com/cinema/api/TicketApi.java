package com.cinema.api;

import com.cinema.controller.model.TicketModel;
import com.cinema.dto.TicketDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Ticket management API")
@RequestMapping("/api/v1/tickets")
public interface TicketApi {
    @ApiOperation("Get ticket from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    TicketModel getTicket(@PathVariable Long id);

    @ApiOperation("Create new ticket")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TicketModel createTicket(@RequestBody TicketDto ticketDto);

    @ApiOperation("Update ticket in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    TicketModel updateTicket(@PathVariable Long id, @RequestBody TicketDto ticketDto);

    @ApiOperation("Delete ticket from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTicket(@PathVariable Long id);
}
