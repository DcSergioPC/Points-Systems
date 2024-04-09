package pointsystem.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Path("test")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RestPrueba {
    @GET
    @Path("/saludo")
    public Map<String, String> saludo(@QueryParam("nombre") String nombre) {
        Map<String,String> mapa=new HashMap<>();
        mapa.put("mensaje","hola"+(nombre!=null && !nombre.trim().isEmpty()?" "+nombre:""));
        return mapa;

    }
}
