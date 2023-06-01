/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;
import Modelo.Dao.ComentarioDao;
import Modelo.Entity.Comentario;
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
@Path("/comentario")
public class ComentarioResource {
    ComentarioDao comentarioDao = new ComentarioDao();
    @GET
    @Path("/evento")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(){
        List<Comentario> comentarios = new ArrayList<>();
        comentarios = comentarioDao.consultar();
        return Response
                .status(200)
                .entity(comentarios)
                .build();
    }
    
 @GET
    @Path("/comentario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("event") String id) {
        Comentario tienda = new Comentario(id);
        return Response
                .status(200)
                .entity(comentarioDao.consultarID(tienda))
                .build();
    }


 @POST
    @Path("/comentario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Comentario comentario)
    {
        try{
            comentarioDao.Insertar(comentario);
            return Response.status(Response.Status.CREATED).entity(comentario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
    
    @DELETE
    @Path("/comentario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Comentario comentario = new Comentario(id);
        int i = comentarioDao.borrar(comentario);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Evento not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/comentario")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Comentario comentario) {
       try{
            comentarioDao.actualizar(comentario);
            return Response.status(Response.Status.CREATED).entity(comentario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

}    
