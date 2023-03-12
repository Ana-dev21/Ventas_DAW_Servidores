<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pedidos</title>
</head>
<body>
    <h1>Pedidos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Fecha</th>
            <th>Total</th>
            <th>Cliente</th>
            <th>Comercial</th>
        </tr>
        <c:forEach items="${pedidos}" var="p">
            <tr>
                <td>${p.idPedido}</td>
                <td>${p.fecha}</td>
                <td>${p.total}</td>
                <td>${p.cliente.nombre}</td>
                <td>${p.comercial.nombre}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Buscar por Cliente</h2>
    <form action="/pedidos/verPorCliente" method="post">
        <input type="text" name="idCliente" placeholder="ID Cliente">
        <input type="submit" value="Buscar">
    </form>
    <h2>Buscar por Fecha</h2>
    <form action="/pedidos/verPorFecha" method="post">
        <input type="date" name="fecha">
        <input type="submit" value="Buscar">
    </form>

</body>