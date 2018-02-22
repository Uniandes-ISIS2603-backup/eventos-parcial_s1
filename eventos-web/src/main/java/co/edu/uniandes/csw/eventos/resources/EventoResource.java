package co.edu.uniandes.csw.eventos.resources;


import co.edu.uniandes.csw.eventos.dtos.EventoDetailDTO;
import co.edu.uniandes.csw.eventos.ejb.EventoLogic;
import co.edu.uniandes.csw.eventos.entities.EventoEntity;
import co.edu.uniandes.csw.eventos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.eventos.mappers.BusinessLogicExceptionMapper;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

@Path("eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EventoResource {
    
    @Inject
    private EventoLogic eventoLogic;

    
    @POST
    public EventoDetailDTO createEvento(EventoDetailDTO evento) throws BusinessLogicException {
        EventoEntity eventoEntity = evento.toEntity();
        eventoEntity = eventoLogic.createEvento(eventoEntity); 
        return new EventoDetailDTO(eventoEntity);
    }


    @GET
    @Path("{id: \\d+}")
    public EventoDetailDTO getEvento(@PathParam("id") Long id) {
        EventoEntity evento = eventoLogic.getEvento(id);
        if (evento == null) 
            throw new WebApplicationException("La evento no existe");
        return new EventoDetailDTO(evento); 
    }
    
 
}
