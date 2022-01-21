/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.dao.daoCliente;
import modelo.entidad.Clientes;

@Path("wsCliente")
public class WsClienteResourse {
    private daoCliente daoCliente;
    
    @Context
    private UriInfo context;

    
    public WsClienteResourse() {
        this.daoCliente = new daoCliente();
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Clientes> consultarClientes() {
      return daoCliente.consultar();
    }

  
}
