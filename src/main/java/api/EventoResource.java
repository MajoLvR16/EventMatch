/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;
import Modelo.Dao.EventoDao;
import Modelo.Entity.Evento;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
@Path("/apievento")
public class EventoResource {
    EventoDao eventoDao = new EventoDao();
    @GET
    @Path("/evento")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(){
        List<Evento> eventos = new ArrayList<>();
        eventos = eventoDao.consultar();
        return Response
                .status(200)
                .entity(eventos)
                .build();
    }
    
 @GET
    @Path("/evento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") String id) {
        Evento tienda = new Evento(id);
        return Response
                .status(200)
                .entity(eventoDao.consultarID(tienda))
                .build();
    }


 @POST
    @Path("/evento")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Evento evento)
    {
        try{
            eventoDao.Insertar(evento);
            return Response.status(Response.Status.CREATED).entity(evento).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
    
    @DELETE
    @Path("/evento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Evento evento = new Evento(id);
        int i = eventoDao.borrar(evento);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Evento not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/evento")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Evento evento) {
       try{
            eventoDao.actualizar(evento);
            return Response.status(Response.Status.CREATED).entity(evento).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

}    
