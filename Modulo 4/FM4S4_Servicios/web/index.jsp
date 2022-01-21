<%-- 
    Document   : index
    Created on : 12-02-2021, 06:31:44 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.entidad.Clientes"%>
<%@page import="modelo.dao.daoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            daoCliente dc = new daoCliente();
            List<Clientes> lst = dc.consultar();
            out.println("Cantidad "+ lst.size());
        
        %>
    </body>
</html>
