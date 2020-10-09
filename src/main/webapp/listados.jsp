<%-- 

    Document   : listados
    Created on : 9 oct. 2020, 16:09:02
    Author     : geofr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
//    valores que recuperamos del servlet, listado y tipo listado.
    String[] elementos = (String[]) request.getAttribute("listado");
    String tipoListado = request.getAttribute("tipoListado").toString();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listados</title>
    </head>
    <body>
        <% if (tipoListado.equalsIgnoreCase("clientes")) {%>
        <!--CLIENTES-->
        <h1> Listado de clientes de la empresa:</h1>
        <% } else if (tipoListado.equalsIgnoreCase("productos")) {%>

        <!--PRODUCTOS-->
        <h1> Listado de productos de la empresa:</h1>
        <%} else {%>

        <!--SUCURSALES-->
        <h1> Listado de sucursales de la empresa:</h1>
        <%}%>
        <%for (int i = 0; i < elementos.length; i++) {%>

        <ul>
            <li><%=elementos[i]%></li>
        </ul>
        <% }%>
    </body>
</html>
