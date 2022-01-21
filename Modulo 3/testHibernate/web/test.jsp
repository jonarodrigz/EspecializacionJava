
<%@page import="java.util.List"%>
<%@page import="edu.formas.FM3S6.modelo.entidad.Cliente"%>
<%@page import="edu.formas.FM3S6.modelo.dao.daoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1>Clientes</h1>
        <%
            daoCliente dc = new daoCliente();
            List<Cliente> lst = dc.getAll();
            for (Cliente c : lst)
            {
                out.println(c.getIdCliente() + " " + c.getNombre() + " " + c.getApellido()+ "<br>");
            }
        %>
    </body>
</html>
