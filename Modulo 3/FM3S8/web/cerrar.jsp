
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesion</title>
    </head>
    <body>
        <%
            HttpSession misesion = request.getSession();
            misesion.setAttribute("isLogin", "false");
            misesion.invalidate();
            response.sendRedirect("ctrlLogin");
            %>
    </body>
</html>
