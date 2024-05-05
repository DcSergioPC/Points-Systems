package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.VencimientoDAO;
import pointsystem.model.Vencimiento;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("vencimiento")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class VencimientoRest {

    @Inject
    VencimientoDAO vencimientoDAO;

    @POST
    @Path("/")
    public Response agregar(Vencimiento p) {
        vencimientoDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(vencimientoDAO.obtenerVencimientos()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        vencimientoDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Vencimiento p) {
        Vencimiento p2=vencimientoDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


