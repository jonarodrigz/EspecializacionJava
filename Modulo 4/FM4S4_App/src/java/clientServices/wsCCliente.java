package clientServices;

import entidad.Clientes;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class wsCCliente {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FM4S4_Servicios/webresources";

    public wsCCliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("wsCliente");
    }

    public <T> T consultarClientes() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(
                (GenericType<T>) new GenericType<List<Clientes>>(){});
    }

    public void close() {
        client.close();
    }
    
}
