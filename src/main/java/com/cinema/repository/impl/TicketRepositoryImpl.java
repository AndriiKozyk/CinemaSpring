package com.cinema.repository.impl;

import com.cinema.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketRepositoryImpl implements com.cinema.repository.TicketRepository {

    private final List<Ticket> list = new ArrayList<>();

    @Override
    public Ticket getTicket(Long id) {
        return list.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        list.add(ticket);
        return ticket;
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        boolean isDeleted = list.removeIf(t -> t.getId().equals(id));
        if (isDeleted) {
            list.add(ticket);
        } else {
            throw new RuntimeException("Ticket does not exist");
        }
        return ticket;
    }

    @Override
    public void deleteTicket(Long id) {
        list.removeIf(ticket -> ticket.getId().equals(id));
    }

}
