package pointsystem.rest;

// import org.hibernate.Session;
import pointsystem.ejb.ClienteDAO;
import pointsystem.model.Cliente;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("cliente")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteRest {

    @Inject
    ClienteDAO clienteDAO;

    @POST
    @Path("/")
    public Response agregar(Cliente p) {
        clienteDAO.agregar(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    public Response lista(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return Response.ok(clienteDAO.obtenerClientes(nombre, apellido)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        clienteDAO.eliminar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar (Cliente p) {
        Cliente p2=clienteDAO.modificar(p);
        return Response.ok(p2).build();
    }
}
