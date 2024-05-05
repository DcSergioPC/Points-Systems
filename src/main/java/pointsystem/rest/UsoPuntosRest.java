package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.UsoPuntosDAO;
import pointsystem.model.UsoPuntos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("usopuntos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsoPuntosRest {

    @Inject
    UsoPuntosDAO usoPuntosDAO;

    @POST
    @Path("/")
    public Response agregar(UsoPuntos p) {
        usoPuntosDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(usoPuntosDAO.obtenerUsoPuntoss()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        usoPuntosDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (UsoPuntos p) {
        UsoPuntos p2=usoPuntosDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


