<%-- 
    Document   : vistaApp
    Created on : 10-21-2021, 08:24:43 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String accion = (String) request.getAttribute("op");
            if (accion.equals("Captura")) {
        %>

        <h1>Captura de los datos</h1>
        <form name="vistaAppF1" method="POST" action="ctrlApp?accion=1">
            Digite el primer numero <input type="text" name="n1"><br>
            Digite el segundo numero <input type="text" name="n2"><br>
            <input type="submit" value="Aceptar"><br>
        </form>

        <%        
            } else {
                int resultado = (Integer) request.getAttribute("Resultado");
                out.println("<h1>Mostrando los resultados</h1>");
                out.println("El producto es " + resultado);
            }
                
        %>

    </body>
</html>
