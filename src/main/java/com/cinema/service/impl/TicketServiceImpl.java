package com.cinema.service.impl;

import com.cinema.dto.TicketDto;
import com.cinema.model.Ticket;
import com.cinema.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements com.cinema.service.TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public TicketDto getTicket(Long id) {
        Ticket ticket = ticketRepository.getTicket(id);
        return mapTicketToTicketDto(ticket);
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = mapTicketDtoToTicket(ticketDto);
        ticketRepository.createTicket(ticket);
        return ticketDto;
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto ticketDto) {
        Ticket ticket = mapTicketDtoToTicket(ticketDto);
        ticketRepository.updateTicket(id, ticket);
        return ticketDto;
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteTicket(id);
    }

    private Ticket mapTicketDtoToTicket(TicketDto ticketDto) {
        return Ticket.builder()
                .userId(ticketDto.getUserId())
                .sessionId(ticketDto.getSessionId())
                .sessionPlaceId(ticketDto.getSessionPlaceId())
                .build();
    }

    private TicketDto mapTicketToTicketDto(Ticket ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                .userId(ticket.getUserId())
                .sessionId(ticket.getSessionId())
                .sessionPlaceId(ticket.getSessionPlaceId())
                .build();
    }

}
