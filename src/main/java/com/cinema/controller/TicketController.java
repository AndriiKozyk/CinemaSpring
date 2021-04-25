package com.cinema.controller;

import com.cinema.controller.assembler.TicketAssembler;
import com.cinema.controller.model.TicketModel;
import com.cinema.dto.TicketDto;
import com.cinema.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final TicketAssembler ticketAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TicketModel getTicket(@PathVariable Long id) {
        log.info("Get ticket by id: {}", id);
        TicketDto ticket = ticketService.getTicket(id);
        return ticketAssembler.toModel(ticket);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TicketModel createTicket(@RequestBody TicketDto ticketDto) {
        log.info("Create ticket {}", ticketDto);
        TicketDto ticket = ticketService.createTicket(ticketDto);
        return ticketAssembler.toModel(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TicketModel updateTicket(@PathVariable Long id, @RequestBody TicketDto ticketDto) {
        log.info("Update ticket by id: {}", id);
        TicketDto ticket = ticketService.updateTicket(id, ticketDto);
        return ticketAssembler.toModel(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        log.info("Delete ticket by id: {}", id);
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

}
