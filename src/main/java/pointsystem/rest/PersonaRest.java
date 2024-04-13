package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.PersonaDAO;
import pointsystem.model.Cliente;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("persona")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PersonaRest {

    @Inject
    PersonaDAO personaDAO;

    @POST
    @Path("/")
    public Response agregar(Cliente p) {
        personaDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(personaDAO.obtenerPersonas(nombre, apellido)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        personaDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Cliente p) {
        Cliente p2=personaDAO.modificar(p);
        return Response.ok(p2).build();
    }
}
