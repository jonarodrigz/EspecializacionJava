<%@page import="edu.formas.s3.modelo.entidad.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Clientes</h1>
        
        <% 
            String op = (String) request.getAttribute("op");
            if(op == null){
                response.sendRedirect("ctrlCliente");
            }
            if(op.equals("mostrar")){
                List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
                for (int i = 0; i < lista.size(); i++) {
                        out.println(lista.get(i).getIdCliente() + " " + lista.get(i).getNombre() + " " + lista.get(i).getApellido()+"<br>");
                    }
            }
        
        %>
    </body>
</html>
