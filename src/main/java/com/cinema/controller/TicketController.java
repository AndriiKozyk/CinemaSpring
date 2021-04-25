package com.cinema.controller;

import com.cinema.api.TicketApi;
import com.cinema.controller.assembler.TicketAssembler;
import com.cinema.controller.model.TicketModel;
import com.cinema.dto.TicketDto;
import com.cinema.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TicketController implements TicketApi {

    private final TicketService ticketService;
    private final TicketAssembler ticketAssembler;

    @Override
    public TicketModel getTicket(Long id) {
        log.info("Get ticket by id: {}", id);
        TicketDto ticket = ticketService.getTicket(id);
        return ticketAssembler.toModel(ticket);
    }

    @Override
    public TicketModel createTicket(TicketDto ticketDto) {
        log.info("Create ticket {}", ticketDto);
        TicketDto ticket = ticketService.createTicket(ticketDto);
        return ticketAssembler.toModel(ticket);
    }

    @Override
    public TicketModel updateTicket(Long id, TicketDto ticketDto) {
        log.info("Update ticket by id: {}", id);
        TicketDto ticket = ticketService.updateTicket(id, ticketDto);
        return ticketAssembler.toModel(ticket);
    }

    @Override
    public ResponseEntity<Void> deleteTicket(Long id) {
        log.info("Delete ticket by id: {}", id);
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

}
