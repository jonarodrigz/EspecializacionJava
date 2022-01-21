<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes</title>
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
        <h1>Estudiantes</h1>
        <a href="ctrlMenu">Menu</a><br>
        
        <c:if test="${requestScope.op=='mostrar'}">
            <table border="1">
                <tr><td><b>Id</b></td><td><b>Nombre</b></td><td><b>Apellido</b></td><td><b>Email</b></td>
                    <td><b>Carrera</b></td><td><a href='ctrlEstudiante?accion=1'>Agregar</a></td><tr>
                    <c:forEach var="item" items="${requestScope.lista}">
                    <tr><td>${item.getIdestudiante()}</td>
                        <td>${item.getNombre()}</td>
                        <td>${item.getApellido()}</td>
                        <td>${item.getEmail()}</td>
                        <td>${item.getCarrera()}</td>
                        <td><a href="ctrlEstudiante?accion=3&id=${item.getIdestudiante()}&nom=${item.getNombre()}
                               &ape=${item.getApellido()}&email=${item.getEmail()}&carre=${item.getCarrera()}">
                                Editar</a> |<a href="ctrlEstudiante?accion=5&id=${item.getIdestudiante()}"> Eliminar</a> | 
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </c:if>
        <c:if test="${requestScope.op=='form'}">
            <form name='captura' action="ctrlEstudiante?accion=2" method="post">
                Nombre <input type="text" name="nom"><br><br>
                Apellido <input type="text" name="ape"><br><br>
                Email <input type="text" name="email"><br><br>
                Carrera <input type="text" name="carre"><br><br>
                <input type="submit" value="Enviar">
            </form>
        </c:if>
        <c:if test="${requestScope.op=='msg'}">
            Resultado : ${requestScope.mensaje} <br>
            <a href="ctrlEstudiante">Regresar</a>
        </c:if>
        <c:if test= "${requestScope.op=='formMod'}">
            <form name='captura' action="ctrlEstudiante?accion=4" method="post">
                Id <input type="text" name="id" value="${requestScope.estudiante.getIdestudiante()}" readonly><br><br>
                Nombre <input type="text" name="nom" value="${requestScope.estudiante.getNombre()}"><br><br>
                Apellido <input type="text" name="ape" value="${requestScope.estudiante.getApellido()}"><br><br>
                Email <input type="text" name="email" value="${requestScope.estudiante.getEmail()}"><br><br>
                Carrera <input type="text" name="carre" value="${requestScope.estudiante.getCarrera()}"><br><br>
                <input type="submit" value="Enviar">
            </form>
        </c:if>
    </body>
</html>
