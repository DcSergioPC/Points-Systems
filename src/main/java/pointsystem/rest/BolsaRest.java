package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.BolsaDAO;
import pointsystem.model.Bolsa;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("bolsa")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class BolsaRest {

    @Inject
    BolsaDAO bolsaDAO;

    @POST
    @Path("/")
    public Response agregar(Bolsa p) {
        bolsaDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(bolsaDAO.obtenerBolsas()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        bolsaDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Bolsa p) {
        Bolsa p2=bolsaDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


