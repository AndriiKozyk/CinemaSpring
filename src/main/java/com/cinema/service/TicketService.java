package com.cinema.service;

import com.cinema.dto.TicketDto;

public interface TicketService {
    TicketDto getTicket(Long id);

    TicketDto createTicket(TicketDto ticketDto);

    TicketDto updateTicket(Long id, TicketDto ticketDto);

    void deleteTicket(Long id);
}
