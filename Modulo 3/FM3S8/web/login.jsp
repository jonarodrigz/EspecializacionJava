
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Inicio de sesion</h1>
        <%
        String mensaje = request.getParameter("error");
        if(mensaje != null){
            if(mensaje.equals("1"))
                out.println("<p><strong style='color: red'>Usuario o clave incorrecta</strong></p>");
            else
                out.println("<p><strong style='color: red'>"+mensaje+"</strong></p>");
        }
        %>
        
        <form name="main" action="ctrlLogin?accion=login" method="POST">
            Digite el Usuario <input type="text" name="txtUsuario"><br>
            Digite la clave <input type="password" name="txtClave"><br>
            <input type="submit" value="Aceptar">
        </form>
    </body>
</html>
