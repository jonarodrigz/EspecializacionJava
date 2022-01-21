
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <% 
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragna", "no-cache");
            response.setDateHeader("Expires", 0);
            
            HttpSession misesion = request.getSession(true);
            String id = misesion.getId();
            
            if(misesion.getAttribute("isLogin")==null){
                String pagina = "ctrlLogin";
                response.sendRedirect(response.encodeRedirectURL(pagina));
                return;
            }
            else{
                String v = misesion.getAttribute("isLogin").toString();
                if(!v.equals("true")){
                    String pagina = "ctrlLogin";
                    response.sendRedirect(response.encodeRedirectURL(pagina));
                    return;
                }
            }
            %>
    </head>
    <body>
        <h1>Menu de Opciones</h1>
        <a href="ctrlEstudiante">Estudiantes</a>
        <a href="cerrar.jsp">Cerrar Sesion</a>
    </body>
</html>
