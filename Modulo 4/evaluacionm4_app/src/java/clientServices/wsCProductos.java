/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientServices;

import entidad.Productos;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:WsProductosResource
 * [wsProductos]<br>
 * USAGE:
 * <pre>
 *        wsCProductos client = new wsCProductos();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Usuario
 */
public class wsCProductos {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/evaluacionm4/webresources";

    public wsCProductos() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("wsProductos");
    }

    public List<Productos> getAll() throws ClientErrorException {
        WebTarget resource = webTarget;
         return resource.request(MediaType.APPLICATION_JSON).get(
                 new GenericType<List<Productos>>(){});
    }

   public void insertar(Productos p){
    WebTarget resource = webTarget;
    resource.request(MediaType.APPLICATION_JSON).post(Entity.entity(p, MediaType.APPLICATION_JSON));
   }
   
    public void actualizar(Productos p){
    WebTarget resource = webTarget;
    resource.request(MediaType.APPLICATION_JSON).put(Entity.entity(p, MediaType.APPLICATION_JSON));
   }
    
     public void eliminar(Integer id){
    WebTarget resource = webTarget.path(""+id);
    
    resource.request(MediaType.APPLICATION_JSON).delete();
   }
   
   
    public void close() {
        client.close();
    }
    
}
