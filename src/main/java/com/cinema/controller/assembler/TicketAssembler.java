package com.cinema.controller.assembler;

import com.cinema.controller.TicketController;
import com.cinema.controller.model.TicketModel;
import com.cinema.dto.TicketDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TicketAssembler extends RepresentationModelAssemblerSupport<TicketDto, TicketModel> {

    public TicketAssembler() {
        super(TicketController.class, TicketModel.class);
    }

    @Override
    public TicketModel toModel(TicketDto entity) {

        TicketModel ticketModel = new TicketModel(entity);

        Link get = linkTo(methodOn(TicketController.class).getTicket(entity.getUserId())).withRel("get");
        Link create = linkTo(methodOn(TicketController.class).createTicket(entity)).withRel("create");
        Link update = linkTo(methodOn(TicketController.class).updateTicket(entity.getId(), entity)).withRel("update");
        Link delete = linkTo(methodOn(TicketController.class).deleteTicket(entity.getUserId())).withRel("delete");

        ticketModel.add(get, create, update, delete);

        return ticketModel;
    }

}
