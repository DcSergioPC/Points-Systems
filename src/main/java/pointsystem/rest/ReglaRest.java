package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.ReglaDAO;
import pointsystem.model.Regla;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("regla")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ReglaRest {

    @Inject
    ReglaDAO reglaDAO;

    @POST
    @Path("/")
    public Response agregar(Regla p) {
        reglaDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(reglaDAO.obtenerReglas(nombre, apellido)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        reglaDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Regla p) {
        Regla p2=reglaDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


