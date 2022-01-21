<%-- 
    Document   : cuenta
    Created on : 11-15-2021, 09:10:36 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="edu.formas.FM3S6.modelo.entidad.Cuenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cuentas</h1>
          <% 
            String op = (String)request.getAttribute("op");
            
            if(op == null){
                response.sendRedirect("ctrlCuenta");
            }
            if(op.equals("mostrar")){
            List<Cuenta> lst = (List<Cuenta>) request.getAttribute("lista");
            for(int i=0; i<lst.size(); i++){
                out.println(lst.get(i).getNumeroCuenta() + " " + lst.get(i).getCliente().getNombre() + " "+ lst.get(i).getSaldo() + "<br>");
            }
            }

        
        %>
    </body>
</html>
