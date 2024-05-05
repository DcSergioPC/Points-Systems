package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.UsoPuntosDetalleDAO;
import pointsystem.model.UsoPuntosDetalle;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("usopuntosdetalle")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsoPuntosDetalleRest {

    @Inject
    UsoPuntosDetalleDAO usoPuntosDetalleDAO;

    @POST
    @Path("/")
    public Response agregar(UsoPuntosDetalle p) {
        usoPuntosDetalleDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(usoPuntosDetalleDAO.obtenerUsoPuntosDetalles()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        usoPuntosDetalleDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (UsoPuntosDetalle p) {
        UsoPuntosDetalle p2=usoPuntosDetalleDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


