package com.cinema.repository;

import com.cinema.model.Ticket;

public interface TicketRepository {
    Ticket getTicket(Long id);

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);
}
