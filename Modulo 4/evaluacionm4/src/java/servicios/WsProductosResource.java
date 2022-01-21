package servicios;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.dao.daoProductos;
import modelo.entidad.Productos;


@Path("wsProductos")
public class WsProductosResource {

    @Context
    private UriInfo context;
    private daoProductos dp;
   
    public WsProductosResource() {
        this.dp = new daoProductos();
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Productos> getAll() {
       return dp.getAll();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean agregar(Productos pro){
        return dp.Insertar(pro);
        
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean actualizar(Productos pro) {
        return  dp.Actualizar(pro);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean eliminar(@PathParam("id") Integer id) {
        return  dp.Eliminar(id);
    }
}
