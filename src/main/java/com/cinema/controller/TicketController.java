package com.cinema.controller;

import com.cinema.dto.TicketDto;
import com.cinema.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TicketDto getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TicketDto createTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.createTicket(ticketDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TicketDto updateTicket(@PathVariable Long id, @RequestBody TicketDto ticketDto) {
        return ticketService.updateTicket(id, ticketDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

}
