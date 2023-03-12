<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle Comercial</title>
</head>
<body>
    <h1>Detalles de ${comercial.nombre}</h1>
    <table>
        <tr>
            <th>Nombre: </th>
            <th>Apellidos: </th>
            <th>Comisión: </th>
            <th>Total ventas: </th>
        </tr>
        <tr>
            <td>${comercial.nombre}</td>
            <td> ${comercial.apellido1} ${comercial.apellido1}</td>
            <td>Comisión: ${comercial.comision}</td>
            <td>Total ventas: ${totalVentas}</td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Fecha</th>
            <th>Importe</th>
        </tr>
        <c:forEach items="${pedidos}" var="p">
            <tr>
                <td>${p.fecha}</td>
                <td>${p.total}</td>
            </tr>
        </c:forEach>
    </table>

</body>



