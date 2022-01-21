<%@page import="edu.formas.FM3S6.modelo.entidad.Cliente"%>
<%@page import="edu.formas.FM3S6.modelo.entidad.Abonos"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.formas.FM3S6.modelo.entidad.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="edu.formas.FM3S6.modelo.dao.daoCuenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cuentas</h1>
     
     <c:if test="${requestScope.op=='mostrar'}">
            <table border="1">
                <tr><td><b>NumeroCuenta</b></td><td><b>Cliente</b></td><td><b>Saldo</b></td><td><a href='ctrlCuenta?accion=1'>Agregar</a></td><tr>
                <c:forEach var="item" items="${requestScope.lista}">
                    <tr><td>${item.getNumeroCuenta()}</td>
                        <td>${item.getCliente()}</td>
                        <td>${item.getSaldo()}</td>
                        <td><a href="ctrlCuenta?accion=3&ncuenta=${item.getNumeroCuenta()}&idCli=${item.getCliente().getIdCliente()}">
                                Editar</a> |<a href="ctrlCuenta?accion=5&nCuenta=${item.getNumeroCuenta()}"> Eliminar</a> | 
                                <a href="ctrlCuenta?accion=6&nCuenta=${item.getNumeroCuenta()}">Agregar Abono</a> | 
                                <a href="ctrlCuenta?accion=8&nCuenta=${item.getNumeroCuenta()}">Ver Abonos</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
         <c:if test="${requestScope.op=='form'}">
            <form name='captura' action="ctrlCuenta?accion=2" method="post">
                Elija un Cliente <select name="idcliente">
                    <% 
                    List<Cliente> lstCli = (List<Cliente>) request.getAttribute("listaCli");
                    for(Cliente cte: lstCli){
                        out.println("<option value='"+cte.getIdCliente()+"'>"+cte+"</option>");
                    }
                    %>
                    
                </select><br>
             
                <input type="submit" value="Enviar">
            </form>
        </c:if>
        <c:if test="${requestScope.op=='msg'}">
            Resultado : ${requestScope.mensaje} <br>
            <a href="ctrlCuenta">Regresar</a>
        </c:if>
            <c:if test= "${requestScope.op=='formMod'}">
                 <form name='captura' action="ctrlCuenta?accion=4" method="post">
                     Id Cliente <input type="text" name="id" value="${requestScope.ncuenta}" readonly><br>
                     Elija un cliente <select name="cliente">
                    <% 
                     List<Cliente> lstCli2 = (List<Cliente>) request.getAttribute("listaCli");
                    for(Cliente cte: lstCli2){
                        out.println("<option value='"+cte.getIdCliente()+"'>"+cte+"</option>");
                    }
                    %>
                    
                </select><br>
                   
                <input type="submit" value="Enviar">
            </form>
            </c:if>
        <c:if test="${requestScope.op=='formAbono'}">
             <h2>Agregar Abonos</h2><br>
             <form name='captura' action="ctrlCuenta?accion=7" method="post">
                 Numero de Cuenta <input type="text" name="id" value="${requestScope.ncuenta}" readonly><br><br>
                     Fecha <input type="date" name="fechaAbono"><br><br>
                     Monto <input type="number" name="montoAbono"><br><br>
                     
                     <input type="submit" value="Agregar">
                           
        </c:if>
       <c:if test="${requestScope.op=='mostrarAbono'}">
           <h2>Lista de Abonos</h2><br>
            <table border="1">
                <tr><td><b>NumeroCuenta</b></td><td><b>Fecha</b></td><td><b>Monto</b></td><tr>
                <c:forEach var="item" items="${requestScope.listaAbonos}">
                    <tr><td>${item.getCuenta().getNumeroCuenta()}</td>
                        <td>${item.getFechaAbono()}</td>
                        <td>${item.getMontoAbono()}</td>
                       
                    </tr>
                </c:forEach>
            </table>
            <a href="ctrlCuenta">Regresar</a>
        </c:if>
    </body>
</html>
