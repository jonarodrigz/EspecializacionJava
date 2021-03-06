/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("prueba")
public class PruebaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PruebaResource
     */
    public PruebaResource() {
    }

    /**
     * Retrieves representation of an instance of servicios.PruebaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMensaje() {
        return "Hola des WS";
    }

    /**
     * PUT method for updating or creating an instance of PruebaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putMensaje(String content) {
        System.out.println("Mensaje" + content);
    }
}
