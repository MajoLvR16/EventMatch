/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;
import Modelo.Dao.TagDao;
import Modelo.Entity.Tag;
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
@Path("/apitag")
public class TagResource {
    TagDao tagDao = new TagDao();
    @GET
    @Path("/tag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(){
        List<Tag> tags = new ArrayList<>();
        tags = tagDao.consultar();
        return Response
                .status(200)
                .entity(tags)
                .build();
    }
    
 @GET
    @Path("/tag/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") String id) {
        Tag tienda = new Tag(id);
        return Response
                .status(200)
                .entity(tagDao.consultarID(tienda))
                .build();
    }


 @POST
    @Path("/tag")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Tag tag)
    {
        try{
            tagDao.Insertar(tag);
            return Response.status(Response.Status.CREATED).entity(tag).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
    
    @DELETE
    @Path("/tag/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") String id) {
        Tag tag = new Tag(id);
        int i = tagDao.borrar(tag);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Tag not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
    @Path("/tag")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Tag tag) {
       try{
            tagDao.actualizar(tag);
            return Response.status(Response.Status.CREATED).entity(tag).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

}    
