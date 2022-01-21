<%-- 
    Document   : cliente
    Created on : 11-15-2021, 08:44:36 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="edu.formas.FM3S6.modelo.entidad.Cliente"%>
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
            String op = (String)request.getAttribute("op");
            
            if(op == null){
                response.sendRedirect("ctrlCliente");
            }
            if(op.equals("mostrar")){
            List<Cliente> lst = (List<Cliente>) request.getAttribute("lista");
            for(int i=0; i<lst.size(); i++){
                out.println(lst.get(i).getNombre());
            }
            }

        
        %>
    </body>
</html>
