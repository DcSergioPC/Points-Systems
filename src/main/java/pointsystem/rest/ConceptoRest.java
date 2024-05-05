package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.ConceptoDAO;
import pointsystem.model.Concepto;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("concepto")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ConceptoRest {

    @Inject
    ConceptoDAO conceptoDAO;

    @POST
    @Path("/")
    public Response agregar(Concepto p) {
        conceptoDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(conceptoDAO.obtenerConceptos()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        conceptoDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Concepto p) {
        Concepto p2=conceptoDAO.modificar(p);
        return Response.ok(p2).build();
    }
}


